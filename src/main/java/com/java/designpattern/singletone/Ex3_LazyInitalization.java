package com.java.designpattern.singletone;

// 인스턴스 낭비는 해결 되지만,
// 여러 스레드가 동시에 getInstance()를 호출한다면 소용 없음!
// (멀티 스레드 환경에서의 동기화 문제)
public class Ex3_LazyInitalization {
  private static Ex3_LazyInitalization instance;

  public Ex3_LazyInitalization() {
  }

  public static Ex3_LazyInitalization getInstance() {
    if (instance == null)
      instance = new Ex3_LazyInitalization();
    return instance;
  }
}
