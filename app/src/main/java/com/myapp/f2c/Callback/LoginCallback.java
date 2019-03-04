package com.myapp.f2c.Callback;

import com.myapp.f2c.Response.AccountDataModel;

public interface LoginCallback extends BaseAPIErrorCallback {
  void onLoginSuccess(AccountDataModel model);
}
