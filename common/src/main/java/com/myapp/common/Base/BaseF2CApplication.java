package com.myapp.common.Base;

import android.app.Application;

public class BaseF2CApplication extends Application {
  private static BaseF2CApplication mF2CContext;
  public static long SERVER_TIME_DIFFERENCE = 0;

  public static BaseF2CApplication getF2CContext() {
    return mF2CContext;
  }

  private static void setF2CApplication(BaseF2CApplication mF2CContext) {
    BaseF2CApplication.mF2CContext = mF2CContext;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    BaseF2CApplication.setF2CApplication(this);
  }
}
