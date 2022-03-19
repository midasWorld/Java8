package com.java.designpattern.builder;

public class User {

  private Long id;
  private String email;
  private String password;
  private String name;

  public User(Long id, String email, String password, String name) {
    this.id = id;
    this.email = email;
    this.password = password;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getName() {
    return name;
  }

  static public class Builder {
    private Long id;
    private String email;
    private String password;
    private String name;

    public Builder() {
    }

    public Builder(User user) {
      this.id = user.id;
      this.email = user.email;
      this.password = user.password;
      this.name = user.name;
    }

    public Builder id(Long id) {
      this.id = id;
      return this;
    }

    public Builder email(String email) {
      this.email = email;
      return this;
    }

    public Builder password(String password) {
      this.password = password;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public User build() {
      return new User(id, email, password, name);
    }
  }
}
