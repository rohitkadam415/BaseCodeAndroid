package com.myapp.model.Request;

import android.os.Parcel;
import android.os.Parcelable;

public class LoginSignUpRequest implements Parcelable {
  private String Username;
  private String Password;

  private LoginSignUpRequest(Parcel in) {
    Username = in.readString();
    Password = in.readString();
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
    dest.writeString(Username);
    dest.writeString(Password);
  }

  public void setUsername(String username) {
    this.Username = username;
  }

  public void setPassword(String password) {
    this.Password = password;
  }
}
