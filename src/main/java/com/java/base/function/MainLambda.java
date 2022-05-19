package com.java.base.function;

public class MainLambda {
  public static void main(String[] args) {

    // 익명 메소드를 사용한 → 람 to the 다
    // 뻔한 녀석들을 빼버리고, 구분을 위해 화살표 넣어 완성!
    MyRunnable r = () -> System.out.println("Hello");

    MySupply s1 = () -> "Hello World";

    MyRunnable r2 = () -> {
      MySupply s2 = () -> "Hello World";
      System.out.println(s2.supply());
    };
    r2.run();
  }
}
