package com.java.designpattern.strategy.woowa.t2st;

public class WalkingRobot extends Robot {

  @Override
  public void display() {
    System.out.println("걷기 로봇");
  }

  @Override
  public void move() {
    System.out.println("걸어서 배달합니다 삐-빅");
  }
}
