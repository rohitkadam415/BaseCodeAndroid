package com.myapp.f2c.Callback;

import com.myapp.f2c.Model.F2CError;

public interface BaseAPIErrorCallback {
  void onOtherError(F2CError error);

  void onEchoMeFail(F2CError error);
}
