package com.myapp.f2c.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class EmptyData implements Parcelable {
  protected EmptyData(Parcel in) {
  }

  public static final Creator<EmptyData> CREATOR = new Creator<EmptyData>() {
    @Override
    public EmptyData createFromParcel(Parcel in) {
      return new EmptyData(in);
    }

    @Override
    public EmptyData[] newArray(int size) {
      return new EmptyData[size];
    }
  };

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
  }
}
