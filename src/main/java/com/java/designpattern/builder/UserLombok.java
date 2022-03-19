package com.java.designpattern.builder;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserLombok {

  private Long id;
  private String email;
  private String password;
  private String name;

  @Builder
  public UserLombok(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public UserLombok(Long id, String email, String password, String name) {
    this.id = id;
    this.email = email;
    this.password = password;
    this.name = name;
  }
}
