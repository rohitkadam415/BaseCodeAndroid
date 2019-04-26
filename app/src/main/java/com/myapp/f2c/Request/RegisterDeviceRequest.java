package com.myapp.f2c.Request;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Rafique Mujawar
 * Date 06-09-2018
 */
public class RegisterDeviceRequest implements Parcelable {
  private String deviceid;
  private String device;
  private String oem;
  private String devicetype;
  private String location;
  private String appversion;
  private String os;
  private String osversion;
  private String fcmtoken;

  public RegisterDeviceRequest() {
  }

  public void setOem(String oem) {
    this.oem = oem;
  }

  public void setAppversion(String appversion) {
    this.appversion = appversion;
  }

  public void setDevice(String device) {
    this.device = device;
  }

  public void setDevicetype(String devicetype) {
    this.devicetype = devicetype;
  }

  public void setFcmtoken(String fcmtoken) {
    this.fcmtoken = fcmtoken;
  }

  public void setDeviceId(String id) {
    this.deviceid = id;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public void setOs(String os) {
    this.os = os;
  }

  public void setOsversion(String osversion) {
    this.osversion = osversion;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.oem);
    dest.writeString(this.appversion);
    dest.writeString(this.device);
    dest.writeString(this.devicetype);
    dest.writeString(this.fcmtoken);
    dest.writeString(this.deviceid);
    dest.writeString(this.location);
    dest.writeString(this.os);
    dest.writeString(this.osversion);
  }

  private RegisterDeviceRequest(Parcel in) {
    this.oem = in.readString();
    this.appversion = in.readString();
    this.device = in.readString();
    this.devicetype = in.readString();
    this.fcmtoken = in.readString();
    this.deviceid = in.readString();
    this.location = in.readString();
    this.os = in.readString();
    this.osversion = in.readString();
  }

  public static final Creator<RegisterDeviceRequest> CREATOR =
      new Creator<RegisterDeviceRequest>() {
        @Override
        public RegisterDeviceRequest createFromParcel(Parcel source) {
          return new RegisterDeviceRequest(source);
        }

        @Override
        public RegisterDeviceRequest[] newArray(int size) {
          return new RegisterDeviceRequest[size];
        }
      };
}
