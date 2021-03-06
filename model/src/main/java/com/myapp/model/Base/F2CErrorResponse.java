package com.myapp.model.Base;

import android.os.Parcel;
import android.os.Parcelable;

import com.myapp.common.Model.EmptyData;
import com.myapp.common.Model.F2CError;


public class F2CErrorResponse extends F2CBaseResponse implements Parcelable {
  private EmptyData data;

  public EmptyData getData() {
    return data;
  }

  public void setData(EmptyData data) {
    this.data = data;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    super.writeToParcel(dest, flags);
    dest.writeParcelable(this.data, flags);
    dest.writeByte(this.status ? (byte) 1 : (byte) 0);
    dest.writeParcelable(this.error, flags);
  }

  private F2CErrorResponse(Parcel in) {
    super(in);
    this.data = in.readParcelable(EmptyData.class.getClassLoader());
    this.status = in.readByte() != 0;
    this.error = in.readParcelable(F2CError.class.getClassLoader());
  }

  public static final Creator<F2CErrorResponse> CREATOR = new Creator<F2CErrorResponse>() {
    @Override
    public F2CErrorResponse createFromParcel(Parcel source) {
      return new F2CErrorResponse(source);
    }

    @Override
    public F2CErrorResponse[] newArray(int size) {
      return new F2CErrorResponse[size];
    }
  };
}
