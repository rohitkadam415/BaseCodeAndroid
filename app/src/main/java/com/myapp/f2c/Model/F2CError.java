package com.myapp.f2c.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class F2CError implements Parcelable {
  private String message;
  private String code;

  public F2CError(Parcel in) {
    message = in.readString();
    code = in.readString();
  }
  public F2CError(String message, String code) {
    this.message = message;
    this.code = code;
  }
  public static final Creator<F2CError> CREATOR = new Creator<F2CError>() {
    @Override
    public F2CError createFromParcel(Parcel in) {
      return new F2CError(in);
    }

    @Override
    public F2CError[] newArray(int size) {
      return new F2CError[size];
    }
  };

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(message);
    dest.writeString(code);
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}
