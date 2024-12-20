// Source code is decompiled from a .class file using FernFlower decompiler.
package com.michelin.ACO.crypto;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import org.apache.commons.codec.binary.Base64;

final class mD {
   private static SecureRandom secureRandom = null;
   private static final Logger logger = Logger.getLogger("XnetCrypto::" + mD.class.getName());

   mD() {
   }

   byte[] a(String var1, Key var2) {
      String var3 = new String(var1.getBytes("UTF-8"));
      byte[] var4 = Base64.decodeBase64(var3.getBytes());
      return this.a(var4, var2);
   }

   byte[] a(byte[] var1, Key var2) {
      Cipher var3 = Cipher.getInstance("AES/CBC/PKCS5Padding");
      int var4 = var1.length - var3.getBlockSize();
      ByteArrayInputStream var5 = new ByteArrayInputStream(var1, var4, var3.getBlockSize());
      byte[] var6 = new byte[var3.getBlockSize()];

      try {
         var5.read(var6);
      } catch (IOException var9) {
      }

      IvParameterSpec ivParameterSpec = new IvParameterSpec(var6);
      AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance("AES");
      algorithmParameters.init(ivParameterSpec);
      var3.init(2, var2, algorithmParameters);
      return var3.doFinal(var1, 0, var4);
   }

   byte[] b(byte[] var1, Key var2) {
      Cipher var3 = Cipher.getInstance("AES/CBC/PKCS5Padding");
      byte[] var4 = new byte[var3.getBlockSize()];
      this.initSecureRandom().nextBytes(var4);
      IvParameterSpec var5 = new IvParameterSpec(var4);
      AlgorithmParameters var6 = AlgorithmParameters.getInstance("AES");
      var6.init(var5);

      try {
         var3.init(1, var2, var6);
      } catch (SecurityException var11) {
         logger.log(Level.SEVERE, "SecurityException: Maybe local_policy.jar and US_export_policy.jar are not the expected ones?");
      }

      byte[] var7 = var3.doFinal(var1);
      ByteArrayOutputStream var8 = new ByteArrayOutputStream(var7.length + var4.length);

      try {
         var8.write(var7);
         var8.write(var4);
      } catch (IOException var10) {
      }

      return var8.toByteArray();
   }

   String c(byte[] var1, Key var2) {
      byte[] var3 = this.b(var1, var2);
      byte[] var4 = Base64.encodeBase64(var3);
      return new String(var4, "UTF-8");
   }

   Key getKeyFromKeyStore(String keyStore, String password) {
      try {
         return this.b(keyStore, password).getKey("alias", password.toCharArray());
      } catch (KeyStoreException var4) {
         logger.log(Level.SEVERE, MessageFormat.format("Can''t find a provider for the {0} type of keystore (keystore: {1})", "JCEKS", keyStore));
      } catch (NoSuchAlgorithmException var5) {
         logger.log(Level.SEVERE, MessageFormat.format("Can''t handle the following {0} algorithm", "AES"));
      } catch (CertificateException var6) {
         logger.log(Level.SEVERE, MessageFormat.format("Can''t load certificates from the {0} keystore", keyStore));
      } catch (IOException var7) {
         if (var7.getCause() instanceof UnrecoverableKeyException) {
            logger.log(Level.SEVERE, MessageFormat.format("Can''t open the {0} keystore: Wrong password!", keyStore));
         } else {
            logger.log(Level.SEVERE, MessageFormat.format("Can''t open or read the {0} keystore; Exception is: {1}", keyStore, var7.getMessage()));
         }
      } catch (UnrecoverableKeyException var8) {
         logger.log(Level.SEVERE, MessageFormat.format("Can''t find the {0} key in the {1} keystore", "alias", keyStore));
      }

      return null;
   }

   private KeyStore b(String fileName, String var2) {
      FileInputStream stream = new FileInputStream(fileName);
      KeyStore keyStore = KeyStore.getInstance("JCEKS");
      keyStore.load(stream, var2.toCharArray());
      return keyStore;
   }

   private SecureRandom initSecureRandom() {
      if (secureRandom == null) {
         try {
            secureRandom = SecureRandom.getInstance("IBMSecureRandom");
         } catch (NoSuchAlgorithmException var4) {
            logger.log(Level.WARNING, MessageFormat.format("{0} algorithm not found, which probably means you''re not using an IBM JRE; Using {1} instead", "IBMSecureRandom", "SHA1PRNG"));

            try {
               secureRandom = SecureRandom.getInstance("SHA1PRNG");
            } catch (NoSuchAlgorithmException var3) {
               logger.log(Level.SEVERE, MessageFormat.format("{0} and {1} algorithms not found; Cryptography services will crash!", "IBMSecureRandom", "SHA1PRNG"));
            }
         }
      }

      return secureRandom;
   }
}
