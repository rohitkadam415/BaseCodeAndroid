package com.myapp.f2c.Request;

import android.os.Parcel;
import android.os.Parcelable;

public class LoginSignUpRequest implements Parcelable {
  private String username;
  private String password;

  protected LoginSignUpRequest(Parcel in) {
    username = in.readString();
    password = in.readString();
  }

  public LoginSignUpRequest() {
  }

  public static final Creator<LoginSignUpRequest> CREATOR = new Creator<LoginSignUpRequest>() {
    @Override
    public LoginSignUpRequest createFromParcel(Parcel in) {
      return new LoginSignUpRequest(in);
    }

    @Override
    public LoginSignUpRequest[] newArray(int size) {
      return new LoginSignUpRequest[size];
    }
  };

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(username);
    dest.writeString(password);
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
