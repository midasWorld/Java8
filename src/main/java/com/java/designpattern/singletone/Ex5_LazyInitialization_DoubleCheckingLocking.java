package com.java.designpattern.singletone;

// DCL
// 인스턴스가 생성되어 있지 않은 시점에만 synchronized 가 실행되게끔...
// volatile 란?
public class Ex5_LazyInitialization_DoubleCheckingLocking {
  private volatile static Ex5_LazyInitialization_DoubleCheckingLocking instance;

  public Ex5_LazyInitialization_DoubleCheckingLocking() {
  }

  public Ex5_LazyInitialization_DoubleCheckingLocking getInstance() {
    if (instance == null) {
      synchronized (Ex5_LazyInitialization_DoubleCheckingLocking.class) {
        if (instance == null)
          instance = new Ex5_LazyInitialization_DoubleCheckingLocking();
      }
    }
    return instance;
  }
}
