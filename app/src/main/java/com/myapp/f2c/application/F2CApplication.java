package com.myapp.f2c.application;

import android.util.Log;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.myapp.f2c.Base.BaseF2CApplication;
import com.myapp.f2c.Contractor.RegisterDeviceContractor;
import com.myapp.f2c.Model.F2CError;
import com.myapp.f2c.Presenter.RegisterDevicePresenter;
import com.myapp.f2c.Request.RegisterDeviceRequest;
import com.myapp.f2c.Utils.SystemUtils;

import io.fabric.sdk.android.Fabric;

public class F2CApplication extends BaseF2CApplication {
  private static final String TAG = F2CApplication.class.getName();
  private static int topFragmentPosition = -1;

  public static void fetchRegistrationToken() {
    FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(
        new OnSuccessListener<InstanceIdResult>() {
          @Override
          public void onSuccess(InstanceIdResult instanceIdResult) {
            sendRegistrationToServer(instanceIdResult.getToken());
          }
        });
  }

  public static void sendRegistrationToServer(String token) {
    RegisterDeviceContractor.RegisterDeviceActionListener listener = new RegisterDevicePresenter(
        new RegisterDeviceContractor.RegisterDeviceView() {
          @Override
          public void onRegisterDeviceSuccess() {
            Log.i(TAG, "onRegisterDeviceSuccess: ");
          }

          @Override
          public void onRegisterDeviceFail(F2CError error) {
            Log.i(TAG, "onRegisterDeviceFail: ");
          }
        });
    RegisterDeviceRequest request = SystemUtils.getRegisterDeviceRequest();
    request.setFcmtoken(token);
    listener.registerDevice(request);
  }


  @Override
  public void onCreate() {
    super.onCreate();
    Fabric.with(this, new Crashlytics());
//    Log.i(TAG, "onCreate: ");
//    if (!LeakCanary.isInAnalyzerProcess(this)) {
//      // This process is dedicated to LeakCanary for heap analysis.
//      // You should not init your app in this process.
//      LeakCanary.install(this);
//    }
//    CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
//        .setDefaultFontPath(getString(R.string.font_path))
//        .setFontAttrId(R.attr.fontPath)
//        .build());

   /* final Fabric fabric = new Fabric.Builder(this)
        .kits(new Crashlytics())
        .debuggable(true)  // Enables Crashlytics debugger
        .build();
    Fabric.with(this, new Crashlytics());*/
  }
}
