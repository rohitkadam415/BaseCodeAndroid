package com.myapp.model.API;


import com.myapp.common.Constant.APIConstants;
import com.myapp.common.Model.EmptyData;
import com.myapp.model.Base.F2CResponse;
import com.myapp.model.Request.RegisterDeviceRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface RegisterDeviceAPI {
  @POST(APIConstants.URL_DEVICE_REGISTRATION)
  Call<F2CResponse<EmptyData>> setDeviceInfo(@Body RegisterDeviceRequest request);
}
