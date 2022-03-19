package com.java.designpattern.builder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

  @Test
  @DisplayName("빌더와 생성자 객체가 동일하다!")
  public void 빌더_테스트() {
    String email = "test@email.com";
    String password = "1234";
    String name = "dooly";

    // 🤔 생성자 사용
    User user = new User(null, email, password, name);

    // ✨ 빌더 패턴 이용
    User build = new User.Builder()
            .email(email)
            .password(password)
            .name(name)
            .build();

    assertThat(build.getEmail()).isEqualTo(user.getEmail());
    assertThat(build.getPassword()).isEqualTo(user.getPassword());
    assertThat(build.getName()).isEqualTo(user.getName());
  }
}