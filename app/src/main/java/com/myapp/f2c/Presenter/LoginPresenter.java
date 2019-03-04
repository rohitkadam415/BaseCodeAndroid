package com.myapp.f2c.Presenter;

import com.myapp.f2c.Apiservice.LoginService;
import com.myapp.f2c.Base.ExecuteInterface;
import com.myapp.f2c.Callback.LoginCallback;
import com.myapp.f2c.Contractor.LoginContractor;
import com.myapp.f2c.Model.F2CError;
import com.myapp.f2c.Request.LoginSignUpRequest;
import com.myapp.f2c.Response.AccountDataModel;

public class LoginPresenter implements LoginContractor.LoginActionListener, LoginCallback {
  private LoginContractor.LoginView loginView;
  private ExecuteInterface<LoginSignUpRequest> mService;

  public LoginPresenter(LoginContractor.LoginView loginView) {
    this.loginView = loginView;
    this.mService = new LoginService(this);
  }

  @Override
  public void login(String username, String password) {
    LoginSignUpRequest mRequest = new LoginSignUpRequest();
    mRequest.setUsername(username);
    mRequest.setPassword(password);
    mService.executeService(mRequest);
  }

  @Override
  public void onLoginSuccess(AccountDataModel model) {
    loginView.onLoginSuccess(model);
  }

  @Override
  public void onOtherError(F2CError error) {
    loginView.onLoginFail(error);
  }

  @Override
  public void onEchoMeFail(F2CError error) {
    loginView.onLoginFail(error);
  }
}
