package com.michelin.ACO.crypto;

final class mz {
   private byte a;
   private mA b;

   mz(byte var1) {
      this.a = var1;
      this.b = new mA((String)null);
   }

   void a(byte[] var1, String var2) {
      mA var3 = this.b;

      for(int var4 = 0; var4 < var1.length; ++var4) {
         mA var5 = (mA)var3.b.get(var1[var4]);
         if (var5 != null) {
            var3 = var5;
         } else {
            if (var4 == var1.length - 1) {
               var3.b.put(var1[var4], new mA(var2));
               break;
            }

            var5 = new mA((String)null);
            var3.b.put(var1[var4], var5);
            var3 = var5;
         }
      }

   }

   String a(byte[] var1) {
      if (var1 == null) {
         return null;
      } else {
         mA var2 = this.b;

         for(int var3 = 0; var3 < var1.length; ++var3) {
            var2 = (mA)var2.b.get(var1[var3]);
            if (var2 == null) {
               return null;
            }

            if (var3 == var1.length - 1 || var1[var3 + 1] == this.a) {
               return var2.a;
            }
         }

         return null;
      }
   }
}
