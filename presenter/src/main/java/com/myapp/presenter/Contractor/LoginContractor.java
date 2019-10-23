package com.myapp.presenter.Contractor;

import com.myapp.common.Response.LoginResponseModel;
import com.myapp.common.Model.F2CError;
import com.myapp.presenter.base.PresenterView;

public interface LoginContractor {

  interface LoginView extends PresenterView {
    void onLoginSuccess(LoginResponseModel dataModel);

    void onLoginFail(F2CError error);
  }

  interface LoginActionListener {
    void login(String username, String password);
  }
}
