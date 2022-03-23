package com.java.designpattern.strategy.woowa.t3st.strategy.temperature;

public class Cold implements TemperatureStrategy {
  @Override
  public void temperature() {
    System.out.println("차갑습니다. 삐-빅");
  }
}
