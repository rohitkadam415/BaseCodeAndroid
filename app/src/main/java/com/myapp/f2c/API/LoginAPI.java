package com.myapp.f2c.API;

import com.myapp.f2c.Base.F2CResponse;
import com.myapp.f2c.Constant.APIConstants;
import com.myapp.f2c.Request.LoginSignUpRequest;
import com.myapp.f2c.Response.AccountDataModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface LoginAPI {
  @POST(APIConstants.URL_LOGIN)
  Call<F2CResponse<AccountDataModel>> getAccessToken(@Body LoginSignUpRequest request);
}

