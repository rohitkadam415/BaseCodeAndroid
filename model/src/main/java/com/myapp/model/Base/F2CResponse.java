package com.myapp.model.Base;

import android.os.Parcel;
import android.os.Parcelable;

import com.myapp.common.Model.F2CError;


public class F2CResponse<T> extends F2CBaseResponse implements Parcelable {
  private T data;

  public boolean isStatus() {
    return status;
  }

  public F2CError getError() {
    return error;
  }

  public T getData() {
    return data;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeByte(this.status ? (byte) 1 : (byte) 0);
    dest.writeParcelable(this.error, flags);

  }

  private F2CResponse(Parcel in) {
    this.status = in.readByte() != 0;
    this.error = in.readParcelable(F2CError.class.getClassLoader());
  }

  public static final Creator<F2CResponse> CREATOR =
      new Creator<F2CResponse>() {
        @Override
        public F2CResponse createFromParcel(Parcel source) {
          return new F2CResponse(source);
        }

        @Override
        public F2CResponse[] newArray(int size) {
          return new F2CResponse[size];
        }
      };
}
