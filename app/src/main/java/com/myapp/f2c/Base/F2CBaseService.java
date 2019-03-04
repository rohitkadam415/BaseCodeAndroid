package com.myapp.f2c.Base;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.myapp.f2c.Constant.F2CErrorConstant;
import com.myapp.f2c.Model.F2CError;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class F2CBaseService<DATA, REQUEST> implements ExecuteInterface<REQUEST> {

  protected void filterCall(Call<F2CResponse<DATA>> call) {
    call.enqueue(new Callback<F2CResponse<DATA>>() {
      @Override
      public void onResponse(@NonNull Call<F2CResponse<DATA>> call,
                             @NonNull Response<F2CResponse<DATA>> response) {
        F2CResponse<DATA> responsebody = response.body();
        if (response.isSuccessful() && null != responsebody && responsebody.isStatus()) {
          onF2CResponse(responsebody.getData());
        } else {
          findErrorDetails(response);
        }
      }

      @Override
      public void onFailure(@NonNull Call<F2CResponse<DATA>> call, @NonNull Throwable t) {
        if (t instanceof SocketTimeoutException) {
          onError(new F2CError(F2CErrorConstant.ERROR_TIME_OUT, t.getMessage()));
        } else if (t instanceof UnknownHostException) {
          onError(new F2CError(F2CErrorConstant.ERROR_NETWORK, t.getMessage()));
        } else if (t instanceof JsonSyntaxException) {
          onError(new F2CError(F2CErrorConstant.ERROR_JSON_SYNTAX, t.getMessage()));
        } else {
          onError(new F2CError(F2CErrorConstant.ERROR_OTHER, t.getMessage()));
        }
      }
    });
  }

  private void findErrorDetails(Response<F2CResponse<DATA>> response) {
    F2CResponse<DATA> body = response.body();
    ResponseBody errorBody = response.errorBody();
    if (null != body && null != body.getError()) {
      onFailure(body.getError());
    } else if (null != errorBody) {
      try {
        String rawError = errorBody.string();
        F2CErrorResponse echoMeError = new Gson().fromJson(rawError, F2CErrorResponse.class);
        if (null != echoMeError) {
          onFailure(echoMeError.error);
        }
      } catch (IOException e) {
        e.printStackTrace();
        F2CError error = new F2CError(F2CErrorConstant.ERROR_IO, F2CErrorConstant.IO_ERROR_CODE);
        onError(error);
      } catch (JsonSyntaxException e) {
        F2CError error =
            new F2CError(F2CErrorConstant.ERROR_JSON_SYNTAX,
                F2CErrorConstant.ERROR_JSON_SYNTAX_CODE);
        onError(error);
      }
    } else {
      F2CError error = new F2CError(F2CErrorConstant.ERROR_UNKNOWN,
          F2CErrorConstant.ERROR_UNKNOWN_CODE);
      onError(error);
    }
  }

  protected abstract void onF2CResponse(DATA echoMeData);

  protected abstract void onFailure(F2CError errorData);

  protected abstract void onError(F2CError error);
}
