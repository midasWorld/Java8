package com.java.base.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
//    new MyRunnable() {
//      @Override
//      public void run() {
//        MySupply mySupply = new MySupply() {
//          @Override
//          public String supply() {
//            return "Hello World";
//          }
//        };
//        System.out.println(mySupply.supply());
//      }
//    }.run();

    List<Integer> lst = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

    Stream<Integer> strema = lst.stream();

    strema.forEach(System.out::println);
    strema.forEach(System.out::println);
  }
}
