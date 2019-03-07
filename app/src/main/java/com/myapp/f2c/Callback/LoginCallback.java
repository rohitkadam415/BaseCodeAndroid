package com.myapp.f2c.Callback;

import com.myapp.f2c.Response.LoginResponseModel;

public interface LoginCallback extends BaseAPIErrorCallback {
  void onLoginSuccess(LoginResponseModel model);
}
