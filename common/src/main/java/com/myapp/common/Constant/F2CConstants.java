package com.myapp.common.Constant;

/**
 * @author Rafique Mujawar
 * Date 21-07-2018
 */
public interface F2CConstants {

  /*
   (?=.*[0-9])       # a digit must occur at least once
   (?=.*[a-z])       # a lower case letter must occur at least once
   (?=.*[A-Z])       # an upper case letter must occur at least once
   (?=.*[@#$%^&+=])  # a special character must occur at least once
   (?=\\S+$)         # no whitespace allowed in the entire string
   .{6,20}           # anything, at least eight places
   */
  String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%])(?=\\S+$).{6,20})";
  String REGEX_MOBILE_NUMBER = "[^0-9]+";
  String EMPTY_STRING = "";
  String F2C_SHARED_PREFERENCES = "F2C_SHARED_PREFERENCES";
  String ARG_INTEGRATION_URL = "ARG_INTEGRATION_URL";
  String ARG_ARTIST_URL = "ARG_ARTIST_URL";
  String PARAM_STATUS = "status";
  String LABEL_SUBSCRIPTION_SUCCESS = "subscription_success";
  String LABEL_SUBSCRIPTION_ERROR = "permission_denied";
  String SPOTIFY_ERROR_AUTH = "kSpErrorLoginBadCredentials";
  String SPOTIFY_ERROR_NO_ACTIVE_DEVICE = "kSpErrorNotActiveDevice";
  String SPOTIFY_PREMIUM = "premium";
  String ARG_USER_ID = "ARG_USER_ID";
  String ARG_TRACKS = "ARG_TRACKS";
  String ARG_PLAYLIST = "ARG_PLAYLIST";
  String SPACE_STRING = " ";
  String BREAK_LINE = "\n";
  String DOT_STRING = ".";
  long DEFAULT_TRACK_START = 0;
  String DURATION_MIN_SECS = "%02d:%02d";
  String ARG_SC_CODE = "code";
  Object TAG_LIKE = "TAG_LIKE";
  String ARG_MOBILE_NUMBER = "ARG_MOBILE_NUMBER";
  String ARG_PUSH_NOTIFICATION = "ARG_PUSH_NOTIFICATION";
  String LABEL_ANDROID = "ANDROID";
  String ARG_INVITE_TO_LISTEN = "ARG_INVITE_TO_LISTEN";
  String ARG_SHARE_SONG = "ARG_SHARE_SONG";
  String LABEL_LIVE_LISTEN_COUNT = "Listening";
  String FROM = "From";
  String TO = "To";
  int NETWORK_FEED_LIMIT = 20;
  int PERSONAL_FEED_LIMIT = 20;
  int BROADCAST_SONGS_COUNT = 10;
  int LIVE_LISTENERS_COUNT_POSITION = 1;
  int MIN_USER_NAME_CHARS = 3;
  String ARG_RETURN_AFTER_LOGIN = "returnafterlogin";
  String ARG_SERVICE_UNAVAILABLE = "Service Unavailable";
  String ECHOME_USER_AGENT = "ECHOME_USER_AGENT";
  String CHANNEL_NAME = "EchoMe Messages";
  int USERNAME_LENGTH = 3;
  String IMAGE_TYPE = "image/*";
  String BLUR_CACHE = "blur transformation";
  String KEY_TOKEN = "token";
  String KEY_USERID = "userid";
  String SORT_ORDER_CONTACT = " ASC";
  String KEY_REMOVE_IMAGE = "remove_image";
  String MORE = " more";
  String PROFILE_IAMGE = "profileImages/";
  CharSequence MEDIA_SESSION = "mediasession";
  String MEDIA_SESSION_MEDIAPLAYER = "MediaSession and MediaPlayer";
  String JPG_EXTENSION = ".jpg";
  String PROVIDER = ".provider";
  String IMAGE_FOLDER = "/EchomeProfile/";
  String ROOT = "root";
  String ARG_APP_OPENED = "APP_OPENED";
  String ARG_CONTENT_TYPE = "text";
  String FIND = "find";
  String ARG_STREAMING_SERVICE_PLAYLIST = "ARG_STREAMING_SERVICE_PLAYLIST";
  String COMMA = ",";
  String SEMI_COLON = ";";
  String FEED_ID = "feedid";
  String PLUS_SYMBOL = "+";
  String ENCRYPTION_ALOGORITHM = "AES";
  String ARG_PROFILE_PIC_URL = "ARG_PROFILE_PIC_URL";
  String ARG_USER_NAME = "ARG_USER_NAME";
  String PREF_ACCOUNT_USERNAME = "PREF_ACCOUNT_USERNAME";
  String PREF_ACCOUNT_PASSWORD = "PREF_ACCOUNT_PASSWORD";
  String PREF_INVITE_TO_LISTEN_INFO = "PREF_INVITE_TO_LISTEN_INFO";
  String PREF_WALKIE_TALKIE_INFO = "PREF_WALKIE_TALKIE_INFO";
  String PREF_INVITE_FRIENDS = "PREF_INVITE_FRIENDS";
  long PROGRESS_SECOND = 50;
  String ARG_SHARE_IS_PRIVATE = "ARG_SHARE_IS_PRIVATE";
  String ARG_SHARE_IS_BROADCASTED = "ARG_SHARE_IS_BROADCASTED";
  String BROADCAST_DIALOG_TITLE = "Start a Station";
  String NEW_COMMENT = "NEW_COMMENT";
  String DELETE_COMMENT = "DELETE_COMMENT";
  String FCM_MESSAGE = "message";
  String FCM_TITLE = "EchoMe";
  String EXTRA_SMS_TO = "smsto:";
  int ONEMILLION = 1000000;
  int ONETHOUSAND = 1000;
  int ONE = 1;
  String DECIMAL_FORMAT = ".#";

  interface RequestCodes {
    int ROUNDEDSQUARE_RADIUS = 15;
  }
}