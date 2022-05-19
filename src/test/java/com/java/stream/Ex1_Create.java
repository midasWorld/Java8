package com.java.stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

class Ex1_Create {

	@Test
	void 배열스트림_생성하기() {
		String[] arr = new String[]{"a", "b", "c"};
		Stream<String> stream = Arrays.stream(arr);
		// 1~2 요소 → [b, c]
		Stream<String> streamOfArrayPart = Arrays.stream(arr, 1 , 3);

		System.out.println(
			MessageFormat.format(
				"streamOfArrayPart: {0}",
				streamOfArrayPart
					.collect(Collectors.joining(", "))
			)
		);
	}
	
	@Test
	void 컬렉션스트림_생성하기() {
		List<String> list = Arrays.asList("aa", "bb", "cc");
		Stream<String> stream = list.stream();
		Stream<String> parallelStream = list.parallelStream(); // 병렬 처리 스트림?? 👀
	}

	@Test
	void 비어있는스트림_생성하기() {
		Stream<String> stream = Stream.empty();

		System.out.println(stream);
	}

	@Test
	void 빌더로생성하기() {
		Stream<String> builderStream = Stream.<String>builder()
			.add("둘리")
			.add("고길동")
			.add("또치")
			.build();

		System.out.println("builderStream: " + builderStream
			.collect(Collectors.joining(", "))
		);
	}

	@Test
	void generate_생성하기() {
		Stream<String> generatedStream = Stream.generate(() -> "hoit").limit(5);

		System.out.println("generatedStream: " + generatedStream
			.collect(Collectors.joining(", "))
		);
	}

	@Test
	void iterate_생성하기() {
		Stream<Integer> iteratedStream = Stream.iterate(30, n -> n + 2).limit(5);

		System.out.println("iteratedStream: " + iteratedStream
			.map(Objects::toString)
			.collect(Collectors.joining(", "))
		);
	}

	@Test
	void 기본타입형_생성하기() {
		// 기본타입 스트림 생성 가능
		// range vs rangeClosed?
		//  - 두번째 인자인 종료지점이 포함되느냐 안되느냐의 차이
		IntStream intStream = IntStream.range(1, 5);			// 1, 2, 3, 4
		LongStream longStream = LongStream.rangeClosed(1, 5);	// 1, 2, 3, 4, 5

		// 제네릭을 사용하지 않아 불필요한 auto-boxing 이 일어나지 않습니다.
		// 필요에 의해 boxed 메서드를 통해 boxing 가능!
		Stream<Integer> boxedIntStream = IntStream.range(1, 5).boxed();

		// Random 을 통해 난수를 쉽게 만들어 후속 작업도 가능합니다.
		DoubleStream doubles = new Random().doubles(3);

		System.out.println("intStream: " + intStream.mapToObj(Objects::toString).collect(Collectors.joining(", ")));
		System.out.println("longStream: " + longStream.mapToObj(Objects::toString).collect(Collectors.joining(", ")));
		System.out.println("boxedIntStream: " + boxedIntStream.map(Objects::toString).collect(Collectors.joining(", ")));
		System.out.println("doubles: " + doubles.mapToObj(Objects::toString).collect(Collectors.joining(", ")));
	}

	@Test
	void 문자열_String으로_생성하기() {
		// String 의 chars() 메서드로 각 문자(char)를 IntStream 으로 변환 가능합니다.
		IntStream charsStream = "Stream".chars();

		// 정규표현식을 활용해서, 각 요소들을 스트림으로 만들 수도 있습니다.
		Stream<String> stringStream = Pattern.compile(", ").splitAsStream("Eric, Elena, Java");

		System.out.println("charsStream: " + charsStream.mapToObj(Objects::toString).collect(Collectors.joining(", ")));
		System.out.println("stringStream: " + stringStream.collect(Collectors.joining(", ")));
	}

	@Test
	void 파일_스트림_생성하기() {
		try {
			Stream<String> lineStream = Files.lines(Paths.get("file.txt"), StandardCharsets.UTF_8);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Data
	@AllArgsConstructor
	class Product {
		String name;
		int amount;
	}

	@Test
	void 병렬_스트림_생성하기() {
		List<Product> productList = Arrays.asList(
			new Product("새콤달콤", 30),
			new Product("새우깡", 120),
			new Product("포카칩", 120),
			new Product("칸쵸", 300)
		);
		Stream<Product> parallelStream = productList.parallelStream();

		boolean isParallel = parallelStream.isParallel();
		System.out.println("parallelStream - 병렬 여부 확인: " + isParallel);

		boolean isMany = parallelStream
			.map(product -> {
				System.out.println(product);
				return product.getAmount() * 10;
			})
			.anyMatch(amount -> {
				System.out.println(amount);
				return amount < 200;
			});
		System.out.println("200원 넘는 제품이 존재하는가: " + isMany);

		Stream<String> parallelStreamByArray = Arrays.stream(new String[] {"새우깡", "새콤달콤"}).parallel();

		IntStream intStream = IntStream.range(1, 150).parallel();
		isParallel = intStream.isParallel();
		System.out.println("intStream - 병렬 여부 확인: " + isParallel);

		intStream = intStream.sequential();
		isParallel = intStream.isParallel();
		System.out.println("intStream - 병렬 여부 확인: " + isParallel);
	}

	@Test
	void 스트림_연결하기() {
		Stream<String> stream1 = Stream.of("Java", "Scala", "Groovy");
		Stream<String> stream2 = Stream.of("Python", "Go", "Swift");
		Stream<String> concat = Stream.concat(stream1, stream2);

		System.out.println("concat: " + concat.collect(Collectors.joining(", ")));
	}
}