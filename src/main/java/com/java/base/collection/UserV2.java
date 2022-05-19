package com.java.base.collection;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class UserV2 {
  private int age;
  private String name;

  public UserV2(int age, String name) {
    this.age = age;
    this.name = name;
  }

  public boolean isOver19() {
    return age > 19;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
      .append("name", name)
      .append("age", age)
      .toString();
  }
}
