package com.java.designpattern.builder;

import org.junit.jupiter.api.Test;

class UserLombokTest {

  @Test
  public void 빌더_테스트() {
    UserLombok build = UserLombok.builder()
            .email("hoit")
            .password("hoit")
            .build();
  }
}