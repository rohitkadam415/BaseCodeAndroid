package com.myapp.f2c.API;

import com.myapp.f2c.Base.F2CResponse;
import com.myapp.f2c.Constant.APIConstants;
import com.myapp.f2c.Model.EmptyData;
import com.myapp.f2c.Request.LoginSignUpRequest;
import com.myapp.f2c.Response.LoginResponseModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface RegisterAPI {
  @POST(APIConstants.URL_REGISTER)
  Call<F2CResponse<EmptyData>> Register(@Body LoginSignUpRequest request);
}

