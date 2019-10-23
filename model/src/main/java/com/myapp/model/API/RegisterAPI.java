package com.myapp.model.API;


import com.myapp.common.Constant.APIConstants;
import com.myapp.common.Model.EmptyData;
import com.myapp.model.Base.F2CResponse;
import com.myapp.model.Request.LoginSignUpRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RegisterAPI {
  @POST(APIConstants.URL_REGISTER)
  Call<F2CResponse<EmptyData>> Register(@Body LoginSignUpRequest request);
}

