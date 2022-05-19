package com.java.base.collection.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MyStream {
  public void usingStream() {
    List<Integer> lst = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    Stream<Integer> stream = lst.stream();
    Stream<Integer> integerStream = stream.filter(x -> x > 1);
  }
}
