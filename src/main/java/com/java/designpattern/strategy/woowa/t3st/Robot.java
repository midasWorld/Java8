package com.java.designpattern.strategy.woowa.t3st;

import com.java.designpattern.strategy.woowa.t3st.strategy.move.MoveStrategy;
import com.java.designpattern.strategy.woowa.t3st.strategy.temperature.TemperatureStrategy;

// ✨ 전략의 분리!
public class Robot {
  private MoveStrategy moveStrategy;
  private TemperatureStrategy temperatureStrategy;

  public Robot(MoveStrategy moveStrategy, TemperatureStrategy temperatureStrategy) {
    this.moveStrategy = moveStrategy;
    this.temperatureStrategy = temperatureStrategy;
  }

  //== 비지니스 로직 ==//
  public void move() {
    moveStrategy.move();
  }

  public void temperature() {
    temperatureStrategy.temperature();
  }

  // Setter를 통해서, 실외에서 하다가 실내로 변경됬을 때, 전략을 바꿀수 있다!
  public void changeMoveStrategy(MoveStrategy moveStrategy) {
    this.moveStrategy = moveStrategy;
  }

  public void changeTemperatureStrategy(TemperatureStrategy temperatureStrategy) {
    this.temperatureStrategy = temperatureStrategy;
  }
}
