package com.myapp.f2c.Utils;

import android.widget.Toast;

import com.myapp.f2c.application.F2CApplication;

public class F2CToast {
  public static void show(String message) {
    Toast.makeText(F2CApplication.getF2CContext(), message, Toast.LENGTH_SHORT).show();
  }

  public static void show(int resId) {
    Toast.makeText(F2CApplication.getF2CContext(), F2CApplication.getF2CContext()
            .getString(resId),
        Toast.LENGTH_SHORT).show();
  }

  public static void show(String message, boolean isShort) {
    Toast.makeText(F2CApplication.getF2CContext(), message,
        isShort ? Toast.LENGTH_SHORT : Toast
            .LENGTH_LONG).show();
  }
}
