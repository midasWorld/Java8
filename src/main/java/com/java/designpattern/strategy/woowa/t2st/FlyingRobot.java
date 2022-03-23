package com.java.designpattern.strategy.woowa.t2st;

public class FlyingRobot extends Robot {
  @Override
  public void display() {
    System.out.println("날기 로봇");
  }

  @Override
  public void move() {
    System.out.println("날아서 빼달합니다. 삐-빅");
  }
}
