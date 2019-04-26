package com.myapp.f2c.Presenter;


import com.myapp.f2c.Apiservice.RegisterDeviceService;
import com.myapp.f2c.Base.ExecuteInterface;
import com.myapp.f2c.Callback.RegisterDeviceCallback;
import com.myapp.f2c.Contractor.RegisterDeviceContractor;
import com.myapp.f2c.Model.F2CError;
import com.myapp.f2c.Request.RegisterDeviceRequest;

public class RegisterDevicePresenter
    implements RegisterDeviceContractor.RegisterDeviceActionListener, RegisterDeviceCallback {

  private final RegisterDeviceContractor.RegisterDeviceView mView;
  private final ExecuteInterface<RegisterDeviceRequest> mService;

  public RegisterDevicePresenter(RegisterDeviceContractor.RegisterDeviceView view) {
    this.mView = view;
    this.mService = new RegisterDeviceService(this);
  }

  @Override
  public void registerDevice(RegisterDeviceRequest request) {
    mService.executeService(request);
  }

  @Override
  public void onRegisterDeviceSuccess() {
    mView.onRegisterDeviceSuccess();
  }

  @Override
  public void onOtherError(F2CError error) {
    mView.onRegisterDeviceFail(error);
  }

  @Override
  public void onEchoMeFail(F2CError error) {
    mView.onRegisterDeviceFail(error);
  }
}