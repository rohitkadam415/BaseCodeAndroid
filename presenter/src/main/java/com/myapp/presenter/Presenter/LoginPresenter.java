package com.myapp.presenter.Presenter;
import com.myapp.common.Response.LoginResponseModel;
import com.myapp.common.Model.F2CError;
import com.myapp.model.Apiservice.LoginService;
import com.myapp.model.Base.ExecuteInterface;
import com.myapp.model.Callback.LoginCallback;
import com.myapp.model.Request.LoginSignUpRequest;
import com.myapp.presenter.Contractor.LoginContractor;

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
  public void onLoginSuccess(LoginResponseModel model) {
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
