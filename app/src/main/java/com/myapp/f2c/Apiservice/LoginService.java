package com.myapp.f2c.Apiservice;

import com.myapp.f2c.API.LoginAPI;
import com.myapp.f2c.Base.F2CBaseService;
import com.myapp.f2c.Base.F2CResponse;
import com.myapp.f2c.Callback.LoginCallback;
import com.myapp.f2c.Manager.F2CSessionManager;
import com.myapp.f2c.Model.F2CError;
import com.myapp.f2c.Request.LoginSignUpRequest;
import com.myapp.f2c.Response.LoginResponseModel;

import java.io.IOException;

import retrofit2.Call;

public class LoginService extends F2CBaseService<LoginResponseModel, LoginSignUpRequest> {
  private final LoginCallback callback;

  public LoginService(LoginCallback callback) {
    this.callback = callback;
  }


  @Override
  protected void onF2CResponse(LoginResponseModel accountDataModel) {
    try {
      F2CSessionManager.getSessionManager()
          .setUserID(accountDataModel.getUserlogin().get(0).getId());
      F2CSessionManager.getSessionManager().addRequestInterceptor();
    } catch (IOException e) {
      e.printStackTrace();
    }

    callback.onLoginSuccess(accountDataModel);
  }

  @Override
  protected void onFailure(F2CError errorData) {
    callback.onEchoMeFail(errorData);
  }

  @Override
  protected void onError(F2CError error) {
    callback.onOtherError(error);
  }

  @Override
  public void executeService(LoginSignUpRequest loginSignUpRequest) {
    Call<F2CResponse<LoginResponseModel>> call = null;
    try {
      call = F2CSessionManager.getSessionManager()
          .getRestAdapter().create(LoginAPI.class).getAccessToken(loginSignUpRequest);
    } catch (IOException e) {
      e.printStackTrace();
    }
    filterCall(call);
  }
}
