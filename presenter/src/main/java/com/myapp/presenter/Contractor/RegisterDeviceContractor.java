package com.myapp.presenter.Contractor;


import com.myapp.common.Model.F2CError;
import com.myapp.model.Request.RegisterDeviceRequest;
import com.myapp.presenter.base.PresenterView;

public interface RegisterDeviceContractor {

  interface RegisterDeviceView extends PresenterView {
    void onRegisterDeviceSuccess();

    void onRegisterDeviceFail(F2CError error);
  }

  interface RegisterDeviceActionListener {
    void registerDevice(RegisterDeviceRequest request);
  }
}