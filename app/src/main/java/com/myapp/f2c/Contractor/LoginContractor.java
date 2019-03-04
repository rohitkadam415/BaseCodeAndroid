package com.myapp.f2c.Contractor;

import com.myapp.f2c.Model.F2CError;
import com.myapp.f2c.Presenter.Base.PresenterView;
import com.myapp.f2c.Response.AccountDataModel;

public interface LoginContractor {

  interface LoginView extends PresenterView {
    void onLoginSuccess(AccountDataModel dataModel);

    void onLoginFail(F2CError error);
  }

  interface LoginActionListener {
    void login(String username, String password);
  }
}
