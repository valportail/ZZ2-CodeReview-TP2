
package com.michelin.ACO.crypto;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public final class mE {
   private static final String format = new String("UTF8");
   private final String string;

   private static final long a(byte[] var0, int var1) {
      long var2 = 0L;
      int var4 = Math.min(var0.length, var1 + 8);
      int var5 = var4;

      while(true) {
         --var5;
         if (var5 < var1) {
            return var2;
         }

         var2 <<= 8;
         var2 |= (long)(var0[var5] & 255);
      }
   }

   private static final void a(long var0, byte[] var2, int var3) {
      int var4 = Math.min(var2.length, var3 + 8);

      for(int var5 = var3; var5 < var4; ++var5) {
         var2[var5] = (byte)((int)var0);
         var0 >>= 8;
      }

   }

   public static String a(String var0) {
      if (var0.indexOf(0) != -1) {
         throw new IllegalArgumentException((new mE(new long[]{2598583114197433456L, -2532951909540716745L, 1850312903926917213L, -7324743161950196342L, 3319654553699491298L})).toString());
      } else {
         byte[] var1;
         try {
            var1 = var0.getBytes(format);
         } catch (UnsupportedEncodingException var12) {
            throw new AssertionError(var12);
         }

         Random var4 = new Random();

         long var2;
         do {
            var2 = var4.nextLong();
         } while(var2 == 0L);

         var4 = new Random(var2);
         StringBuffer var5 = new StringBuffer((new mE(new long[]{-6733388613909857970L, -557652741307719956L, 563088487624542180L, 5623833171491374716L, -2309350771052518321L, 2627844803624578169L})).toString());
         toHex(var5, var2);
         int var6 = var1.length;

         for(int var7 = 0; var7 < var6; var7 += 8) {
            long var8 = var4.nextLong();
            long var10 = a(var1, var7) ^ var8;
            var5.append(", ");
            toHex(var5, var10);
         }

         var5.append((new mE(new long[]{2755852131294600893L, -3127777435315167413L, -3908846051857568038L})).toString());
         return var5.toString();
      }
   }

   private static final void toHex(StringBuffer var0, long var1) {
      var0.append("0x");
      var0.append(Long.toHexString(var1).toUpperCase());
      var0.append('L');
   }

   public mE(long[] var1) {
      int var2 = var1.length;
      byte[] var3 = new byte[8 * (var2 - 1)];
      long var4 = var1[0];
      Random var6 = new Random(var4);

      for(int var7 = 1; var7 < var2; ++var7) {
         long var8 = var6.nextLong();
         a(var1[var7] ^ var8, var3, 8 * (var7 - 1));
      }

      String var11;
      try {
         var11 = new String(var3, format);
      } catch (UnsupportedEncodingException var10) {
         throw new AssertionError(var10);
      }

      int var12 = var11.indexOf(0);
      this.string = var12 != -1 ? var11.substring(0, var12) : var11;
   }

   public String toString() {
      return this.string;
   }
}
