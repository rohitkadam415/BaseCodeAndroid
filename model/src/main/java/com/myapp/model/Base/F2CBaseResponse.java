package com.myapp.model.Base;

import android.os.Parcel;
import android.os.Parcelable;

import com.myapp.common.Model.F2CError;


public class F2CBaseResponse implements Parcelable {
  boolean status;
  F2CError error;

  F2CBaseResponse(Parcel in) {
    status = in.readByte() != 0;
    error = in.readParcelable(F2CError.class.getClassLoader());
  }

  F2CBaseResponse() {
  }

  public static final Creator<F2CBaseResponse> CREATOR = new Creator<F2CBaseResponse>() {
    @Override
    public F2CBaseResponse createFromParcel(Parcel in) {
      return new F2CBaseResponse(in);
    }

    @Override
    public F2CBaseResponse[] newArray(int size) {
      return new F2CBaseResponse[size];
    }
  };

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeByte((byte) (status ? 1 : 0));
    dest.writeParcelable(error, flags);
  }

  @Override
  public int describeContents() {
    return 0;
  }

}
