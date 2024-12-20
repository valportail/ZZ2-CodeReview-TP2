package com.michelin.xnet.crypto.eclipselink;

import com.michelin.ACO.crypto.mC;
import com.michelin.ACO.crypto.mE;
import com.michelin.xnet.utils.config.Config;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.persistence.mappings.DatabaseMapping;
import org.eclipse.persistence.mappings.converters.Converter;
import org.eclipse.persistence.sessions.Session;

public final class CryptoConverter implements Converter {
   private mC facade;
   private static final Logger LOGGER = Logger.getLogger("XnetCrypto::" + CryptoConverter.class.getName());

   public CryptoConverter() {
   }

   public void initialize(DatabaseMapping var1, Session var2) {
      try {
         Class var5 = Class.forName((new mE(new long[]{1642940691953937415L, 8122658300533809099L, 420653948247446461L, 892322739556006539L, -5459530972555273964L})).toString(), true, Thread.currentThread().getContextClassLoader());
         Method var3 = var5.getDeclaredMethod((new mE(new long[]{-8151974305300400127L, -4831114558398088680L})).toString());
         Object var6 = var3.invoke((Object)null);

         Method var4 = var6.getClass().getDeclaredMethod((new mE(new long[]{-5170065878286463152L, -8465785477224363286L})).toString());
         String var7 = (String)var4.invoke(var6);
         Config var8 = Config.getInstance();
         if (var8 != null && var8.getProperty(String.class, "crypto.keystore") != null) {
            this.facade = mC.a((String)var8.getProperty(String.class, "crypto.keystore"), var7);
         } else {
            this.facade = mC.a((String)null, var7);
         }
      } catch (Exception var9) {
         LOGGER.log(Level.SEVERE, MessageFormat.format("Unable to intialize Xnet cryptography services; The application will surely crash: {0}", var9.getMessage()));
      }

   }

   public boolean isMutable() {
      return false;
   }

   public Object convertDataValueToObjectValue(String data) {
      return data instanceof String ? this.facade.decrypt(data) : null;
   }

   public String convertObjectValueToDataValue(Object object) {
      return this.facade.encrypt(object);
   }
}
