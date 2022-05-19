package com.java.base.function;

@FunctionalInterface
public interface MySupply {
  String supply();
  default void dooly() {}   // 얘는 괞춘..
  static void hoit() {}     // 얘도 괞춘..
}
