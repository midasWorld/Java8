package com.java.designpattern.singletone;

// 정적 블럭 초기화, Thread - safe
// static block을 통해서 Exception Handling 제공하지만, 그거 빼고는 EagerInitialization와 동일
public class Ex2_StaticBlockInitialization {
  private static Ex2_StaticBlockInitialization instance;

  public Ex2_StaticBlockInitialization() {
  }

  static {
    try {
      instance = new Ex2_StaticBlockInitialization();
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  public static Ex2_StaticBlockInitialization getInstance() {
    return instance;
  }
}
