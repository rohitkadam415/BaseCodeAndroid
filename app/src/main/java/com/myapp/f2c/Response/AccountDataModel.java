package com.myapp.f2c.Response;

import android.os.Parcel;
import android.os.Parcelable;

public class AccountDataModel implements Parcelable {
  private String token;
  private String min_supported_version;

  private AccountDataModel(Parcel in) {
    token = in.readString();
    min_supported_version = in.readString();
  }

  public static final Creator<AccountDataModel> CREATOR = new Creator<AccountDataModel>() {
    @Override
    public AccountDataModel createFromParcel(Parcel in) {
      return new AccountDataModel(in);
    }

    @Override
    public AccountDataModel[] newArray(int size) {
      return new AccountDataModel[size];
    }
  };

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(token);
    dest.writeString(min_supported_version);
  }
}
