package com.java.designpattern.singletone;

// 이른 초기화, Thread - safe
// 사용하지 않더라도 생성되므로 자원 낭비...
public class Ex1_EagerInitialization {
  private static final Ex1_EagerInitialization instance = new Ex1_EagerInitialization();

  private Ex1_EagerInitialization() {} // 차단?

  public static Ex1_EagerInitialization getInstance() {
    return instance;
  }
}
