package com.java.designpattern.strategy.woowa.t2st;

public class RunningRobot extends Robot{

  @Override
  public void display() {
    System.out.println("뛰긴 로봇");
  }

  @Override
  public void move() {
    System.out.println("뛰어서 배달합니다 삐-빅");
  }
}
