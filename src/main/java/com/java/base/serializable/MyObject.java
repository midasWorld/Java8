package com.java.base.serializable;

import java.io.Serializable;

public class MyObject implements Serializable {
  public int value;

  public MyObject(final int value) {
    this.value = value;
  }
}
