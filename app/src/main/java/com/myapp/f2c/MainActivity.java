package com.myapp.f2c;

import android.os.Bundle;
import android.util.Log;

import com.myapp.common.Constant.F2CConstants;
import com.myapp.common.Model.F2CError;
import com.myapp.common.Response.LoginResponseModel;
import com.myapp.f2c.ottoeventbus.BusProvider;
import com.myapp.f2c.ottoeventbus.testEvent;
import com.myapp.presenter.Contractor.LoginContractor.LoginActionListener;
import com.myapp.presenter.Contractor.LoginContractor.LoginView;
import com.myapp.presenter.Presenter.LoginPresenter;
import com.squareup.otto.Subscribe;


public class MainActivity extends F2CActivity implements LoginView {

  private static final String TAG = MainActivity.class.getSimpleName();
  LoginActionListener loginActionListener;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    loginActionListener = new LoginPresenter(this);
    loginActionListener.login("de", "Pass@12");
    initToolbar();
    setUpToolbar(getString(R.string.app_name), 0, R.drawable.ic_arrow_back_black_24dp, 0);
  }

  @Override
  public void onLoginSuccess(LoginResponseModel dataModel) {
    Log.i(TAG, "onLoginSuccess: ");
    BusProvider.getInstance().post(new testEvent(F2CConstants.EMPTY_STRING));
  }

  @Override
  public void onLoginFail(F2CError error) {
    Log.i(TAG, "onLoginFail: " + error.getMessage());
  }

  @Subscribe
  public void subscribeForTestEvent(testEvent event) {
    Log.i(TAG, "subscribeForTestEvent: ");
  }

  @Override
  protected void onStart() {
    super.onStart();
    BusProvider.getInstance().register(MainActivity.this);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    BusProvider.getInstance().unregister(MainActivity.this);
  }
}
