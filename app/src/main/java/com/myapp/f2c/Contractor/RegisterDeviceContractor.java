package com.myapp.f2c.Contractor;


import com.myapp.f2c.Model.F2CError;
import com.myapp.f2c.Presenter.Base.PresenterView;
import com.myapp.f2c.Request.RegisterDeviceRequest;

public interface RegisterDeviceContractor {

  interface RegisterDeviceView extends PresenterView {
    void onRegisterDeviceSuccess();

    void onRegisterDeviceFail(F2CError error);
  }

  interface RegisterDeviceActionListener {
    void registerDevice(RegisterDeviceRequest request);
  }
}