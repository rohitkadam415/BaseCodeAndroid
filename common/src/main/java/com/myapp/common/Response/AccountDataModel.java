package com.myapp.common.Response;

import android.os.Parcel;
import android.os.Parcelable;

public class AccountDataModel implements Parcelable {
  private String Id;
  private String Username;
  private String Password;
  private String IsVerified;
  private String UsertypeId;

  protected AccountDataModel(Parcel in) {
    Id = in.readString();
    Username = in.readString();
    Password = in.readString();
    IsVerified = in.readString();
    UsertypeId = in.readString();
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
    dest.writeString(Id);
    dest.writeString(Username);
    dest.writeString(Password);
    dest.writeString(IsVerified);
    dest.writeString(UsertypeId);
  }

  public String getId() {
    return Id;
  }
}
