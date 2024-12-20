package com.michelin.xnet.crypto.grails;

import com.michelin.ACO.crypto.mC;
import com.michelin.ACO.crypto.mE;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class SimpleCryptoHandler {
   private static final Logger LOGGER = Logger.getLogger(SimpleCryptoHandler.class.getName());
   private mC facade;

   public SimpleCryptoHandler(String var1) {
      try {
         Class var4 = Class.forName((new mE(new long[]{-8986732235973050073L, -6497729707523766762L, -8288613700403925373L, 1365972465865545358L, 5691332945532211299L})).toString(), true, Thread.currentThread().getContextClassLoader());
         Method var2 = var4.getDeclaredMethod((new mE(new long[]{656445270904799409L, 239297309973187611L})).toString());
         Object var5 = var2.invoke((Object)null);
         Method var3 = var5.getClass().getDeclaredMethod((new mE(new long[]{-6704157949232290634L, 4033087034327257981L})).toString());
         String var6 = (String)var3.invoke(var5);
         this.facade = mC.a(var1, var6);
      } catch (Exception var7) {
         LOGGER.log(Level.SEVERE, MessageFormat.format("Unable to intialize Xnet cryptography services; The application will surely crash: {0}", var7.getMessage()));
      }

   }

   public Object decrypt(Object var1) {
      return var1 instanceof String ? this.facade.a((String)var1) : null;
   }

   public Object encrypt(Object var1) {
      return this.facade.a(var1);
   }
}
