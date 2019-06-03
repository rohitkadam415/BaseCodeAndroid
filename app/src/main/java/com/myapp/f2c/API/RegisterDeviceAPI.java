package com.myapp.f2c.API;


import com.myapp.f2c.Base.F2CResponse;
import com.myapp.common.Constant.APIConstants;
import com.myapp.f2c.Model.EmptyData;
import com.myapp.f2c.Request.RegisterDeviceRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RegisterDeviceAPI {
  @POST(APIConstants.URL_DEVICE_REGISTRATION)
  Call<F2CResponse<EmptyData>> setDeviceInfo(@Body RegisterDeviceRequest request);
}
