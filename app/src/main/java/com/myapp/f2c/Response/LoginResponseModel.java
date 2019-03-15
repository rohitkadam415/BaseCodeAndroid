package com.myapp.f2c.Response;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class LoginResponseModel implements Parcelable {
  List<AccountDataModel> userlogin;

  protected LoginResponseModel(Parcel in) {
    userlogin = in.createTypedArrayList(AccountDataModel.CREATOR);
  }

  public static final Creator<LoginResponseModel> CREATOR = new Creator<LoginResponseModel>() {
    @Override
    public LoginResponseModel createFromParcel(Parcel in) {
      return new LoginResponseModel(in);
    }

    @Override
    public LoginResponseModel[] newArray(int size) {
      return new LoginResponseModel[size];
    }
  };

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeTypedList(userlogin);
  }

  public List<AccountDataModel> getUserlogin() {
    return userlogin;
  }
}
