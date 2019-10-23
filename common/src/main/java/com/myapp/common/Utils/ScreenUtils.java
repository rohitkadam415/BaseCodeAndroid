package com.myapp.common.Utils;

import android.app.Activity;
import android.util.DisplayMetrics;

public class ScreenUtils {
  private static int mScreenWidthInPx = 0;

  public static void setScreenHeightWidth(Activity context) {
    DisplayMetrics metrics = new DisplayMetrics();
    context.getWindowManager().getDefaultDisplay().getMetrics(metrics);
    mScreenWidthInPx = Math.round(metrics.widthPixels);
  }

  public static int getThreeFourthWidthInPX() {
    float width = mScreenWidthInPx * 3.0f / 4.0f;
    return (int) width;
  }

  public static int getSubscriptionDialogWidthInPX() {
    float width = mScreenWidthInPx * 65f / 100f;
    return (int) width;
  }
}
