package com.myapp.model.Callback;


import com.myapp.common.Response.LoginResponseModel;

public interface LoginCallback extends BaseAPIErrorCallback {
  void onLoginSuccess(LoginResponseModel model);
}
