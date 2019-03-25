package com.myapp.f2c.Utils;

import com.myapp.f2c.Constant.F2CConstants;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

class AESUtils {

  private static final byte[] keyValue =
      new byte[]{'e', 'c', 'h', 'o', 'm', 'e', 'a', 'p', 'l', 'i', 'c', 'a', 't', 'i', 'o', 'n'};

  static String encrypt(String cleartext)
      throws Exception {
    byte[] rawKey = getRawKey();
    byte[] result = encrypt(rawKey, cleartext.getBytes());
    return toHex(result);
  }

  static String decrypt(String encrypted)
      throws Exception {

    byte[] enc = toByte(encrypted);
    byte[] result = decrypt(enc);
    return new String(result);
  }

  private static byte[] getRawKey() {
    SecretKey key = new SecretKeySpec(keyValue, F2CConstants.ENCRYPTION_ALOGORITHM);
    return key.getEncoded();
  }

  private static byte[] encrypt(byte[] raw, byte[] clear) throws Exception {
    SecretKey skeySpec = new SecretKeySpec(raw, F2CConstants.ENCRYPTION_ALOGORITHM);
    Cipher cipher = Cipher.getInstance(F2CConstants.ENCRYPTION_ALOGORITHM);
    cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
    return cipher.doFinal(clear);
  }

  private static byte[] decrypt(byte[] encrypted)
      throws Exception {
    SecretKey skeySpec = new SecretKeySpec(keyValue, F2CConstants.ENCRYPTION_ALOGORITHM);
    Cipher cipher = Cipher.getInstance(F2CConstants.ENCRYPTION_ALOGORITHM);
    cipher.init(Cipher.DECRYPT_MODE, skeySpec);
    return cipher.doFinal(encrypted);
  }

  private static byte[] toByte(String hexString) {
    int len = hexString.length() / 2;
    byte[] result = new byte[len];
    for (int i = 0; i < len; i++) {
      result[i] = Integer.valueOf(hexString.substring(2 * i, 2 * i + 2),
          16).byteValue();
    }
    return result;
  }

  private static String toHex(byte[] buf) {
    if (buf == null) {
      return F2CConstants.EMPTY_STRING;
    }
    StringBuffer result = new StringBuffer(2 * buf.length);
    for (byte lByte : buf) {
      appendHex(result, lByte);
    }
    return result.toString();
  }

  private final static String HEX = "0123456789ABCDEF";

  private static void appendHex(StringBuffer sb, byte b) {
    sb.append(HEX.charAt((b >> 4) & 0x0f)).append(HEX.charAt(b & 0x0f));
  }
}
