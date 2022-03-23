package com.java.designpattern.singletone;

public class Ex6_LazyInitalization_LazyHolder {

  public Ex6_LazyInitalization_LazyHolder() {
  }

  private static class InnerInstanceClass {
    // 클래스 로딩 시점에서 생성?
    private static final Ex6_LazyInitalization_LazyHolder instance = new Ex6_LazyInitalization_LazyHolder();
  }

  public static Ex6_LazyInitalization_LazyHolder getInstance() {
    return InnerInstanceClass.instance;
  }
}
