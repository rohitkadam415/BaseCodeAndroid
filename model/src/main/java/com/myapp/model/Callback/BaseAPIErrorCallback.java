package com.myapp.model.Callback;


import com.myapp.common.Model.F2CError;

public interface BaseAPIErrorCallback {
  void onOtherError(F2CError error);

  void onEchoMeFail(F2CError error);
}
