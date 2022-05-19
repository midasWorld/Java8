package com.java.function;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SupplierTest {

	long start = 0;

	@BeforeEach
	void setup() {
		start = System.currentTimeMillis();
	}

	@AfterEach
	void tearDown() {
		long time = (System.currentTimeMillis() - start) / 1000;
		System.out.println("Time taken: " + time + " second");
	}

	@Test
	void printTest() {
		printIndexOverZero(1, getDooly());
		printIndexOverZero(-1, getDooly());
		printIndexOverZero(-2, getDooly());
	}

	@Test
	void supplierTest() {
		printIndexOverZeroUsingSupplier(1, this::getDooly);
		printIndexOverZeroUsingSupplier(-1, this::getDooly);
		printIndexOverZeroUsingSupplier(-2, this::getDooly);
	}

	private String getDooly() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		return "dooly";
	}

	void printIndexOverZero(int index, String value) {
		if (index > 0) {
			System.out.println("Success print value: " + value);
		} else {
			System.out.println("Invalid");
		}
	}

	void printIndexOverZeroUsingSupplier(int index, Supplier<String> supplier) {
		if (index > 0) {
			System.out.println("Success print value: " + supplier.get());
		} else {
			System.out.println("Invalid");
		}
	}
}
