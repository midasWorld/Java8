package com.java.base.collection;

import jdk.jfr.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class MyCollectionTest {
  MyCollection<?> lst;

  @AfterEach
  public void after() {
    System.out.println("------------------");
  }
  
  @Test @Description(value = "와.. map 함수를 직접 만들 수 있다니!?")
  void 콜렉션_테스트() {
    MyCollection<String> c1 = new MyCollection<>(Arrays.asList("A", "CA", "BSB", "CDDD", "EFDAE"));
    MyCollection<Integer> c2 = c1.map(String::length);
    c2.foreach(System.out::println);
  }

  @Test @Description(value = "가독성이 개선 되었다. c1, c2를 굳이 생성해주지 않아도 된다!")
  void 콜렉션_테스트V2() {
    new MyCollection<>(Arrays.asList("A", "CA", "BSB", "CDDD", "EFDAE"))
          .map(String::length)
          .foreach(System.out::println);
  }

  @Test @Description(value = "filter 함수도 만들어보다니... 😳")
  void 콜렉션_테스트_필터추가() {
    new MyCollection<>(Arrays.asList("A", "CA", "BSB", "CDDD", "EFDAE"))
            .map(String::length)
            .filter(i -> i % 2 == 1)
            .foreach(System.out::println);
  }
  
  @Test @Description(value = "객체도 사용해보자!")
  void 콜렉션_객체_테스트() {
    new MyCollection<>(
      Arrays.asList(
        new User(13, "AAA"),
        new User(14, "BBB"),
        new User(15, "CCC"),
        new User(16, "DDD"),
        new User(17, "EEE"),
        new User(18, "FFF"),
        new User(19, "GGG"),
        new User(20, "HHH"),
        new User(21, "III")
      )
    )
    .filter(u -> u.getAge() >= 19)
    .map(User::getName)
    .foreach(System.out::println);
  }

  @Test @Description(value = "객체 커스텀 해서, 정보를 가져오지 않고 사용해보자!")
  void 콜렉션_커스텀된_객체_테스트() {
    new MyCollection<>(
            Arrays.asList(
                    new UserV2(13, "AAA"),
                    new UserV2(14, "BBB"),
                    new UserV2(15, "CCC"),
                    new UserV2(16, "DDD"),
                    new UserV2(17, "EEE"),
                    new UserV2(18, "FFF"),
                    new UserV2(19, "GGG"),
                    new UserV2(20, "HHH"),
                    new UserV2(21, "III")
            )
    )
            .filter(UserV2::isOver19)
            .foreach(System.out::println);
  }
}