package com.java.base.collection.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MyStreamTest {

  @Test
  void testStream() {
    List<Integer> lst = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

    Stream<Integer> stream = lst.stream();

    stream.forEach(System.out::println);
    stream.forEach(System.out::println);
  }
}