package com.myapp.f2c.Apiservice;

import android.util.Log;

import com.myapp.f2c.API.RegisterDeviceAPI;
import com.myapp.f2c.Base.F2CBaseService;
import com.myapp.f2c.Base.F2CResponse;
import com.myapp.f2c.Callback.RegisterDeviceCallback;
import com.myapp.common.Manager.F2CSessionManager;
import com.myapp.f2c.Model.EmptyData;
import com.myapp.f2c.Model.F2CError;
import com.myapp.f2c.Request.RegisterDeviceRequest;

import java.io.IOException;

import retrofit2.Call;

public class RegisterDeviceService extends F2CBaseService<EmptyData, RegisterDeviceRequest> {
  private final RegisterDeviceCallback callback;
  private String TAG=RegisterDeviceService.class.getSimpleName();
  public RegisterDeviceService(
      RegisterDeviceCallback callback) {
    this.callback = callback;
  }

  @Override
  public void executeService(RegisterDeviceRequest request) {
    Call<F2CResponse<EmptyData>> call = null;
    try {
      call = F2CSessionManager.getSessionManager().getRestAdapter
          ().create(RegisterDeviceAPI.class).setDeviceInfo(request);
    } catch (IOException e) {
      e.printStackTrace();
    }
    filterCall(call);
  }

  @Override
  public void onF2CResponse(EmptyData echoMeData) {
    Log.i(TAG, "onEchoMeResponse");
    callback.onRegisterDeviceSuccess();
  }

  @Override
  public void onFailure(F2CError errorData) {
    Log.i(TAG, "onEchoMeFailure");
    callback.onEchoMeFail(errorData);
  }

  @Override
  public void onError(F2CError error) {
    Log.i(TAG, "onError");
    callback.onOtherError(error);
  }
}
