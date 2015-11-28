// Author: Ben Page [ug73bxp] 
package org.xron.security;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

//TODO: Passwords should be stored in char[] not string, as String is immutable.

/**
 * @author Ben Page [ug73bxp@cs.bham.ac.uk]
 */
public class Borker {

  private static Borker instance = getInstance();
  DESKeySpec keySpec;
  SecretKeyFactory keyFactory;
  SecretKey key;
  sun.misc.BASE64Encoder base64encoder;
  sun.misc.BASE64Decoder base64decoder;

  public Borker() throws InvalidKeySpecException, InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
    keySpec = new DESKeySpec("Your secret Key phrase".getBytes("UTF8"));
    keyFactory = SecretKeyFactory.getInstance("DES");
    key = keyFactory.generateSecret(keySpec);
    base64encoder = new BASE64Encoder();
    base64decoder = new BASE64Decoder();
  }

  public static String bork(String s) {
    return instance.base64encoder.encode(s.getBytes());
  }

  public static String debork(String s) {
    byte[] decoded;
    try {
      decoded = instance.base64decoder.decodeBuffer(s);
    } catch (IOException ex) {
      Logger.getLogger(Borker.class.getName()).log(Level.SEVERE, null, ex);
      throw new RuntimeException("Debork failed!");
    }
    return new String(decoded);
  }

  private static Borker getInstance() {
    try {
      return new Borker();
    } catch (Exception ex) {
      Logger.getLogger(Borker.class.getName()).log(Level.SEVERE, null, ex);
      throw new RuntimeException("Cannot use Borker, :(");
    }
  }

  public void go() throws Exception {

    // ENCODE plainTextPassword String
    String plainTextPassword = "password";
    byte[] cleartext = plainTextPassword.getBytes("UTF8");

    Cipher cipher = Cipher.getInstance("DES"); // cipher is not thread safe
    cipher.init(Cipher.ENCRYPT_MODE, key);
    String encryptedPwd = base64encoder.encode(cipher.doFinal(cleartext));
// now you can store it
//        ...
//        ...
    // DECODE encryptedPwd String

    byte[] encrypedPwdBytes = base64decoder.decodeBuffer(encryptedPwd);

//        Cipher cipher = Cipher.getInstance("DES");// cipher is not thread safe
    cipher.init(Cipher.DECRYPT_MODE, key);
    byte[] plainTextPwdBytes = (cipher.doFinal(encrypedPwdBytes));
  }
}
