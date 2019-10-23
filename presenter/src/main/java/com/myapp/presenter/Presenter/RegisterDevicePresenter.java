package com.myapp.presenter.Presenter;
import com.myapp.common.Model.F2CError;
import com.myapp.model.Apiservice.RegisterDeviceService;
import com.myapp.model.Base.ExecuteInterface;
import com.myapp.model.Callback.RegisterDeviceCallback;
import com.myapp.model.Request.RegisterDeviceRequest;
import com.myapp.presenter.Contractor.RegisterDeviceContractor;

public class RegisterDevicePresenter implements RegisterDeviceContractor.RegisterDeviceActionListener, RegisterDeviceCallback {
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