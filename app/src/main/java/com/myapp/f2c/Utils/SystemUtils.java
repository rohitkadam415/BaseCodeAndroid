package com.myapp.f2c.Utils;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.provider.SyncStateContract;

import com.myapp.f2c.BuildConfig;
import com.myapp.f2c.Constant.F2CConstants;
import com.myapp.f2c.Request.RegisterDeviceRequest;
import com.myapp.f2c.application.F2CApplication;

import java.lang.reflect.Field;

public class SystemUtils {

  private static String getDeviceId(Context context) {
    return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
  }

  private static String getDeviceOSName() {
    Field[] fields = Build.VERSION_CODES.class.getFields();
    return fields[Build.VERSION.SDK_INT].getName();
  }

  public static RegisterDeviceRequest getRegisterDeviceRequest() {
    RegisterDeviceRequest request = new RegisterDeviceRequest();
    request.setDeviceId(SystemUtils.getDeviceId(F2CApplication.getF2CContext()));
    request.setOs(SystemUtils.getDeviceOSName());
    request.setDevice(Build.MODEL);
    request.setDevicetype(F2CConstants.LABEL_ANDROID);
    request.setOem(Build.MANUFACTURER);
    request.setAppversion(BuildConfig.VERSION_NAME);
    request.setOsversion(Build.VERSION.RELEASE);
    request.setLocation(F2CConstants.SPACE_STRING);
    return request;
  }
}