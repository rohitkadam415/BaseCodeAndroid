package com.myapp.f2c;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.myapp.f2c.Model.F2CError;
import com.myapp.f2c.Presenter.LoginPresenter;
import com.myapp.f2c.Contractor.LoginContractor;
import com.myapp.f2c.Response.AccountDataModel;

public class MainActivity extends AppCompatActivity implements LoginContractor.LoginView {

  private static final String TAG = MainActivity.class.getCanonicalName();
  LoginContractor.LoginActionListener loginActionListener;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    loginActionListener = new LoginPresenter(this);
    loginActionListener.login("rafique", "Pas@12");
  }

  @Override
  public void onLoginSuccess(AccountDataModel dataModel) {
    Log.i(TAG, "onLoginSuccess: " + dataModel.toString());
  }

  @Override
  public void onLoginFail(F2CError error) {
    Log.i(TAG, "onLoginFail: " + error.getMessage());
  }
}
