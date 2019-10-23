package com.myapp.model.API;

import com.myapp.common.Constant.APIConstants;
import com.myapp.common.Response.LoginResponseModel;
import com.myapp.model.Base.F2CResponse;
import com.myapp.model.Request.LoginSignUpRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface LoginAPI {
  @POST(APIConstants.URL_LOGIN)
  Call<F2CResponse<LoginResponseModel>> getAccessToken(@Body LoginSignUpRequest request);
}

