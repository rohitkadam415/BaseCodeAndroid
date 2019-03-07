package com.myapp.f2c.Manager;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import com.myapp.f2c.Base.BaseF2CApplication;
import com.myapp.f2c.Constant.APIConstants;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class F2CSessionManager {
  private static final int REQUEST_TIMEOUT = 75;
  private static final long MAX_CATCH_SIZE = (10 * 1024 * 1024);//10MB
  private volatile static F2CSessionManager sessionManager = null;
  private static final String baseUrl = "https://apif2c.herokuapp.com/";
  private Retrofit restAdapter;
  private String accessToken;
  private String userID;

  private static void createRestAdapter() {
    sessionManager.restAdapter = new Retrofit.Builder().baseUrl(baseUrl).client(getLoggerClient())
        .addConverterFactory(GsonConverterFactory.create()).build();
  }

  /**
   * Method to get instance of session manager
   *
   * @return - instance of sxm session manager
   * @throws IOException - throws IOException if base url is not provided
   */
  public static F2CSessionManager getSessionManager() throws IOException {
    if (sessionManager == null) {
      synchronized (F2CSessionManager.class) {
        if (sessionManager == null) {
          sessionManager = new F2CSessionManager();
          if (TextUtils.isEmpty(baseUrl)) {
            Log.e("IOException", "BaseUrl not provided : " + "url not defined");
            throw new IOException("Un defined url");
          }
          createRestAdapter();
        }
      }
    }
    return sessionManager;
  }

  /**
   * Implementation of Https to the framework
   *
   * @return OkHttpClient Returns OkHttpClient object with ssl support.
   */
  private static OkHttpClient getLoggerClient() {
    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient.Builder builder = new OkHttpClient.Builder();
    builder.readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS);
    builder.writeTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS);
    builder.connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS);
    builder.addInterceptor(loggingInterceptor);
    Cache cache = new Cache(BaseF2CApplication.getF2CContext().getCacheDir(), MAX_CATCH_SIZE);
    builder.cache(cache);
    return builder.build();
  }

  /**
   * Implementation of Https to the framework
   *
   * @return OkHttpClient Returns OkHttpClient object with ssl support.
   */
  private OkHttpClient getOkHttpClient() {
    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient.Builder builder = new OkHttpClient.Builder();
    builder.readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS);
    builder.writeTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS);
    builder.connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS);
    builder.addInterceptor(getRequestInterceptor());
    builder.addInterceptor(loggingInterceptor);
    Cache cache = new Cache(BaseF2CApplication.getF2CContext().getCacheDir(), MAX_CATCH_SIZE);
    builder.cache(cache);
    return builder.build();
  }

  private Interceptor getRequestInterceptor() {

    return new Interceptor() {
      @Override
      public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();
        Headers.Builder builder = request.headers().newBuilder();
        builder.add(APIConstants.HEADER_KEY_CONTENT_TYPE,
            APIConstants.HEADER_VALUE_CONTENT_TYPE);
        if (!TextUtils.isEmpty(sessionManager.accessToken)) {
          builder.add(APIConstants.HEADER_KEY_TOKEN, sessionManager.accessToken);
        }
        if (!TextUtils.isEmpty(sessionManager.userID)) {
          builder.set(APIConstants.HEADER_KEY_X_USER_ID,
              sessionManager.userID);// existing header UPDATED if available, else added.
        }
        Headers moreHeaders = builder.build();
        request = request.newBuilder().headers(moreHeaders).build();
        return chain.proceed(request);
      }
    };
  }

  public Retrofit getRestAdapter() {
    return restAdapter;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public void setUserID(String userID) {
    this.userID = userID;
  }
}
