package com.java.designpattern.singletone;

// 앞선 6개는 Java - Reflection 을 통해서 파괴 가능??
// 직렬화-역직렬화 과정에서도 파괴 가능
// Joshua Bloc h의 Enum 으로 싱글톤을 구현

// Enum 인스턴스 생성은 기본적으로 스레드 Safe!
// 복잡한 직렬화와 Reflection 통한 제 2의 인스턴스 생성 막음!
// But! 만들려는 Singletone이 Enum 외의 클래스 상속이 안된다...
public enum Ex7_EnumSingletone {
  INSTANCE;
}
