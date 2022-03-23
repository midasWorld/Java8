package com.java.designpattern.singletone;

// 동기화 문제 해결을 위해 synchronized 사용
// synchronized 의 비용자체가 크다? → 인스턴스 호출이 빈번하면 성능이 떨어진다?
public class Ex4_LazyInitializationWithSynchronized {
  private static Ex4_LazyInitializationWithSynchronized instance;

  public Ex4_LazyInitializationWithSynchronized() {
  }

  public static synchronized Ex4_LazyInitializationWithSynchronized getInstance() {
    if (instance == null)
      instance = new Ex4_LazyInitializationWithSynchronized();
    return instance;
  }
}
