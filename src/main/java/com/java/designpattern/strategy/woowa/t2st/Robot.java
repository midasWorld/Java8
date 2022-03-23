package com.java.designpattern.strategy.woowa.t2st;

// ✨ 상속을 이용한 분리!
// 🤔 이것의 문제점은, 온도조절 함수가 추가 된다면?
// 바꿔야되는 클래스가 많다!!
public abstract class Robot {
  public abstract void display();
  public abstract void move();
}