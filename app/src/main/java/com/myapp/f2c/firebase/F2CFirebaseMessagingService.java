package com.myapp.f2c.firebase;

public class F2CFirebaseMessagingService {
  // extends F2CFirebaseMessagingService
//  private static final String TAG = F2CFirebaseMessagingService.class.getName();
//
//  /**
//   * There are two types of messages data messages and notification messages.
//   * Data messages are handled here in onMessageReceived whether the app is in the foreground or background.
//   * Data messages are the type traditionally used with GCM.
//   * Notification messages are only received here in onMessageReceived when the app is in the foreground.
//   * When the app is in the background an automatically generated notification is displayed.
//   * When the user taps on the notification they are returned to the app.
//   * Messages containing both notification and data payloads are treated as notification messages.
//   * The Firebase console always sends notification messages.
//   * For more see: https://firebase.google.com/docs/cloud-messaging/concept-options
//   *
//   * @param remoteMessage {@link RemoteMessage}
//   */
//  @Override
//  public void onMessageReceived(RemoteMessage remoteMessage) {
//    super.onMessageReceived(remoteMessage);
//    RemoteMessage.Notification notification = remoteMessage.getNotification();
//    Map<String, String> data = remoteMessage.getData();
//    Log.i(TAG, "onMessageReceived:getFrom: " + remoteMessage.getFrom());
//    Log.i(TAG, "onMessageReceived: getSentTime:" + remoteMessage.getSentTime());
//    Log.i(TAG, "onMessageReceived: getCollapseKey:" + remoteMessage.getCollapseKey());
//    Log.i(TAG, "onMessageReceived: getMessageId:" + remoteMessage.getMessageId());
//    Log.i(TAG, "onMessageReceived: getMessageType:" + remoteMessage.getMessageType());
//    Log.i(TAG, "onMessageReceived: getTo:" + remoteMessage.getTo());
//    Log.i(TAG, "onMessageReceived: getData:" + data);
//    Log.i(TAG, "onMessageReceived: getOriginalPriority:" + remoteMessage.getOriginalPriority());
//    Log.i(TAG, "onMessageReceived: getPriority:" + remoteMessage.getPriority());
//    Log.i(TAG, "onMessageReceived: getTtl:" + remoteMessage.getTtl());
//    Log.i(TAG, "onMessageReceived: getNotification:" + notification);
//    Log.i(TAG, "onMessageReceived: " + EchoMeAccountManager
//        .getInstance().getChatReceiverid());
//    Log.i(TAG, "keyid: " + data.get(EchomeChatConstants.KEY_ID));
//    Log.i(TAG, "keyid: " + EchoMeAccountManager.getInstance().getChatReceiverid());
//    Log.i(TAG, "keytype: " + data.get(EchomeChatConstants.KEY_TYPE));
//    Log.i(TAG, "keytype: " + EchomeChatConstants.DIRECT_MESSAGE);
//
//    if (null != data) {
//      if (isPublishNotification(data)) {
//        PublishedNotificationHandler.getInstance().handlePublishNotification(data);
//      } else if (
//          data.get(EchomeChatConstants.KEY_TYPE).equals(EchomeChatConstants.DIRECT_MESSAGE) &&
//              EchoMeAccountManager.getInstance().isIsChatActivityOpen() && EchoMeAccountManager
//              .getInstance().getChatReceiverid().equals(data.get(EchomeChatConstants.KEY_ID))) {
//      } else {
//        sendNotification(data);
//      }
//    }
//  }
//
//  /**
//   * Called if InstanceID token is updated. This may occur if the security of
//   * the previous token had been compromised. Note that this is called when the InstanceID token
//   * is initially generated so this is where you would retrieve the token.
//   */
//  @Override
//  public void onNewToken(String token) {
//    super.onNewToken(token);
//    // If you want to send messages to this application instance or
//    // manage this apps subscriptions on the server side, send the
//    // Instance ID token to your app server.
//    Log.i(TAG, "onNewToken: token");
//    EchoMeApplication.sendRegistrationToServer(token);
//  }
//
//  /**
//   * Create and show a simple notification containing the received FCM message.
//   *
//   * @param data FCM data
//   */
//  private void sendNotification(final Map<String, String> data) {
//
//    if (data.get(EchomeChatConstants.KEY_TYPE).equals(EchomeChatConstants.DIRECT_MESSAGE)) {
//      if (null != (data.get(EchomeChatConstants.KEY_AVATARIMAGE))) {
//        generatenotification(data, getBitmapFromURL(data.get(EchomeChatConstants.KEY_AVATARIMAGE)));
//      } else {
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.avatar_image);
//        generatenotification(data, bitmap);
//      }
//      BusProvider.getInstance().post(new RecentChatEvent(getString(R.string.space)));
//    } else {
//      generatenotification(data, null);
//    }
//  }
//
//  private boolean isPublishNotification(Map<String, String> data) {
//    boolean isPublish = (null != data && data.containsKey(EchoMeConstants.FCM.FCM_TYPE) &&
//        data.get(EchoMeConstants.FCM.FCM_TYPE).contains(EchoMeConstants.FCM.FCM_PUBLISH));
//    Log.i(TAG, "isPublishNotification: " + isPublish);
//    return isPublish;
//  }
//
//  public void generatenotification(Map<String, String> data, Bitmap bitmap) {
//    Random random = new Random();
//    int uniqueID = random.nextInt(1000);
//    Intent intent;
//    intent = new Intent(this, MainActivity.class);
//    intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
//    intent.putExtra(EchoMeConstants.ARG_PUSH_NOTIFICATION, new HashMap<>(data));
//    PendingIntent pendingIntent =
//        PendingIntent.getActivity(this, uniqueID, intent, PendingIntent.FLAG_ONE_SHOT);
//    String channelId = getString(R.string.default_notification_channel_id);
//    Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//    NotificationCompat.Builder notificationBuilder =
//        new NotificationCompat.Builder(this, channelId);
//    notificationBuilder.setContentTitle(data.get(EchoMeConstants.TITLE))
//        .setSmallIcon(R.drawable.notification_icon)
//        .setColor(getResources().getColor(R.color.white))
//        .setContentText(data.get(EchoMeConstants.FCM_MESSAGE))
//        .setAutoCancel(true)
//        .setSound(defaultSoundUri)
//        .setPriority(NotificationManager.IMPORTANCE_HIGH)
//        .setContentIntent(pendingIntent);
//    if (bitmap != null) {
//      notificationBuilder.setLargeIcon(bitmap);
//    }
//
//    NotificationManager notificationManager =
//        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//
//    if (null != notificationManager) {
//      // Since android Oreo notification channel is needed.
//      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//        NotificationChannel channel = new NotificationChannel(channelId,
//            EchoMeConstants.CHANNEL_NAME,
//            NotificationManager.IMPORTANCE_HIGH);
//        notificationManager.createNotificationChannel(channel);
//      }
//      notificationManager.notify(uniqueID /* ID of notification */, notificationBuilder.build());
//    }
//  }
//
//  public Bitmap getBitmapFromURL(String src) {
//    try {
//      URL url = new URL(src);
//      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//      connection.setDoInput(true);
//      connection.connect();
//      InputStream input = connection.getInputStream();
//      Bitmap myBitmap = BitmapFactory.decodeStream(input);
//      return getCircleBitmap(myBitmap);
//    } catch (IOException e) {
//      e.printStackTrace();
//      return null;
//    }
//  }
//
//  private Bitmap getCircleBitmap(Bitmap bitmap) {
//    final Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
//        bitmap.getHeight(), Bitmap.Config.ARGB_8888);
//    final Canvas canvas = new Canvas(output);
//
//    final int color = Color.RED;
//    final Paint paint = new Paint();
//    final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
//    final RectF rectF = new RectF(rect);
//
//    paint.setAntiAlias(true);
//    canvas.drawARGB(0, 0, 0, 0);
//    paint.setColor(color);
//    canvas.drawOval(rectF, paint);
//
//    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
//    canvas.drawBitmap(bitmap, rect, rect, paint);
//
//    bitmap.recycle();
//
//    return output;
//  }
}