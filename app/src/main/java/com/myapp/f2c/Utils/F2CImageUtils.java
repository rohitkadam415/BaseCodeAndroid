package com.myapp.f2c.Utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.myapp.common.Constant.F2CConstants;
import com.myapp.f2c.R;
import com.myapp.f2c.application.F2CApplication;

public class F2CImageUtils {
  public static void setProfileImage(ImageView view, String source) {
    setImageViaGlide(view, source, getGlideRequests());
  }

  public static void setMusicImage(ImageView view, String source, int placeHolder) {
    setImageViaGlide(view, source, getRoundCornerGlideRequests(placeHolder));
  }

  public static void setImageViaGlide(ImageView view, String source, RequestOptions options) {
    RequestBuilder builder = Glide.with(F2CApplication.getF2CContext()).load(source);
    if (null != options) {
      builder = builder.apply(options);
    }
    builder.into(view);
  }
  private static RequestOptions getGlideRequests() {
    return getRequest(R.drawable.ic_launcher_background).circleCrop();
  }


  private static RequestOptions getRequest(int placeholder) {
    RequestOptions requestOptions = new RequestOptions();
    requestOptions = requestOptions.placeholder(placeholder);
    requestOptions = requestOptions.error(placeholder);
    return requestOptions.diskCacheStrategy(DiskCacheStrategy.RESOURCE);
  }

  private static RequestOptions getRoundCornerGlideRequests(int placeHolder) {
    return getRequest(placeHolder).transform(
        new RoundedCorners(F2CConstants.RequestCodes.ROUNDEDSQUARE_RADIUS));
  }

}
