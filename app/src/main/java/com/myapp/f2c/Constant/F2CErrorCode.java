package com.myapp.f2c.Constant;


public enum F2CErrorCode {
  ERROR116("ERROR116", "Invalid Username or Password format. Username must " +
      "consist of at least of 3 charaters and maximum of 50 characters. Password must consist of at least 6 characters and maximum of 20 characters. Username/Password should not contain white spaces."),
  ERROR117("ERROR117", "Invalid Username format. Username must be consist of at " +
      "least of 3 charaters and maximum of 50 characters. Also Username should not contain whitspaces."),
  ERROR118("ERROR118", "Invalid Password format. password does not contain " +
      "whitespaces and length should be in between 6 to 20 characters."),
  ERROR123("ERROR123", "Invalid Username/Password"),
  ERROR124("ERROR124", "No user details found with this username"),
  ERROR125("ERROR125", "Username can not be blank");

  private String code;
  private String message;

  F2CErrorCode(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}
