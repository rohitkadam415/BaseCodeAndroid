package com.myapp.f2c.Utils;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;

import java.lang.reflect.Field;

public class SystemUtils {

  private static String getDeviceId(Context context) {
    return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
  }

  private static String getDeviceOSName() {
    Field[] fields = Build.VERSION_CODES.class.getFields();
    return fields[Build.VERSION.SDK_INT].getName();
  }

//  public static RegisterDeviceRequest getRegisterDeviceRequest() {
//    RegisterDeviceRequest request = new RegisterDeviceRequest();
//    request.setDeviceId(SystemUtils.getDeviceId(EchoMeApplication.getEchoMeContext()));
//    request.setOs(SystemUtils.getDeviceOSName());
//    request.setDevice(Build.MODEL);
//    request.setDevicetype(EchoMeConstants.LABEL_ANDROID);
//    request.setOem(Build.MANUFACTURER);
//    request.setAppversion(BuildConfig.VERSION_NAME);
//    request.setOsversion(Build.VERSION.RELEASE);
//    request.setLocation(EchoMeConstants.SPACE_STRING);
//    return request;
//  }
}