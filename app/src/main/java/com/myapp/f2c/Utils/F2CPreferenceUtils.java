package com.myapp.f2c.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.myapp.common.Constant.F2CConstants;

import java.util.HashMap;

public class F2CPreferenceUtils {
  public static void clearPrefs(Context context) {
    SharedPreferences preferences = context
        .getSharedPreferences(F2CConstants.F2C_SHARED_PREFERENCES, Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = preferences.edit();
    editor.clear();
    editor.apply();
  }

  public static void setAccountDetails(String username, String password,Context context) {
    SharedPreferences.Editor editor =
        context.getSharedPreferences(F2CConstants
            .F2C_SHARED_PREFERENCES, Context.MODE_PRIVATE).edit();
    try {
      editor.putString(F2CConstants.PREF_ACCOUNT_USERNAME, AESUtils.encrypt(username));
      editor.putString(F2CConstants.PREF_ACCOUNT_PASSWORD, AESUtils.encrypt(password));
    } catch (Exception e) {
      e.printStackTrace();
    }
    editor.apply();
  }

  public static HashMap<String, String> getUserNamePassword(Context context) {
    SharedPreferences prefs = context
        .getSharedPreferences(F2CConstants.F2C_SHARED_PREFERENCES, Context.MODE_PRIVATE);
    HashMap<String, String> stringStringHashMap = new HashMap<>();
    try {
      stringStringHashMap.put(F2CConstants.PREF_ACCOUNT_USERNAME,
          AESUtils.decrypt(prefs.getString(F2CConstants.PREF_ACCOUNT_USERNAME, null)));
      stringStringHashMap.put(F2CConstants.PREF_ACCOUNT_PASSWORD,
          AESUtils.decrypt(prefs.getString(F2CConstants.PREF_ACCOUNT_PASSWORD, null)));
    } catch (Exception e) {
      e.printStackTrace();
    }

    return stringStringHashMap;
  }


  public static boolean isAlreadyLogin(Context context) {
    SharedPreferences prefs =
        context.getSharedPreferences(F2CConstants
            .F2C_SHARED_PREFERENCES, Context.MODE_PRIVATE);
    return (null != prefs.getString(F2CConstants.PREF_ACCOUNT_USERNAME, null) &&
        null != prefs.getString(F2CConstants.PREF_ACCOUNT_PASSWORD, null));
  }

}
