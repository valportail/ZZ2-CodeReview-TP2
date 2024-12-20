// Source code is decompiled from a .class file using FernFlower decompiler.
package com.michelin.ACO.crypto;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidParameterSpecException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public final class mC {
   private static final String a = "byte[]";
   private static final String b = Boolean.class.getName();
   private static final String c = Date.class.getName();
   private static final String d = java.util.Date.class.getName();
   private static final String e = Double.class.getName();
   private static final String f = Float.class.getName();
   private static final String g = Integer.class.getName();
   private static final String h = Long.class.getName();
   private static final String i = String.class.getName();
   private static final String j = Time.class.getName();
   private static final String k = Timestamp.class.getName();
   private static final byte[] l = "byte[]".getBytes();
   private static final byte[] m;
   private static final byte[] n;
   private static final byte[] o;
   private static final byte[] p;
   private static final byte[] q;
   private static final byte[] r;
   private static final byte[] s;
   private static final byte[] t;
   private static final byte[] u;
   private static final byte[] v;
   private static final mz w;
   private static final String x = "data/key.ks";
   private static Map y;
   private mD z = new mD();
   private String A = null;
   private Key B = null;
   private static final Logger C;

   static {
      m = b.getBytes();
      n = c.getBytes();
      o = d.getBytes();
      p = e.getBytes();
      q = f.getBytes();
      r = g.getBytes();
      s = h.getBytes();
      t = i.getBytes();
      u = j.getBytes();
      v = k.getBytes();
      w = new mz((byte)58);
      w.a(l, "byte[]");
      w.a(m, b);
      w.a(n, c);
      w.a(o, d);
      w.a(p, e);
      w.a(q, f);
      w.a(r, g);
      w.a(s, h);
      w.a(t, i);
      w.a(u, j);
      w.a(v, k);
      y = new HashMap(5, 2.0F);
      C = Logger.getLogger("XnetCrypto::" + mC.class.getName());
   }

   private mC(String var1, String var2) {
      this.A = var1;
      this.B = this.z.a(var1, var2);
   }

   public static mC a(String var0, String var1) {
      if (var0 == null) {
         var0 = "data/key.ks";
         C.log(Level.WARNING, MessageFormat.format("No keystore specified; Using the default location: {0}", var0));
      }

      mC var2 = (mC)y.get(var0);
      if (var2 == null) {
         synchronized(y) {
            var2 = new mC(var0, var1);
            y.put(var0, var2);
         }
      }

      return var2;
   }

   public String a(Object var1) {
      if (var1 == null) {
         return null;
      } else {
         String var2 = null;

         try {
            byte[] var3;
            if (var1 instanceof byte[]) {
               var3 = new byte[l.length + 1 + ((byte[])var1).length];
               System.arraycopy(l, 0, var3, 0, l.length);
               var3[l.length] = 58;
               System.arraycopy(var1, 0, var3, l.length + 1, ((byte[])var1).length);
            } else if (var1 instanceof Boolean) {
               var3 = (b + ':' + ((Boolean)var1).toString()).getBytes("UTF-8");
            } else if (var1 instanceof Date) {
               var3 = (c + ':' + Long.toString(((Date)var1).getTime())).getBytes("UTF-8");
            } else if (var1 instanceof Time) {
               var3 = (j + ':' + Long.toString(((Time)var1).getTime())).getBytes("UTF-8");
            } else if (var1 instanceof Timestamp) {
               var3 = (k + ':' + Long.toString(((Timestamp)var1).getTime())).getBytes("UTF-8");
            } else if (var1 instanceof java.util.Date) {
               var3 = (d + ':' + Long.toString(((java.util.Date)var1).getTime())).getBytes("UTF-8");
            } else if (var1 instanceof Double) {
               var3 = (e + ':' + ((Double)var1).toString()).getBytes("UTF-8");
            } else if (var1 instanceof Float) {
               var3 = (f + ':' + ((Float)var1).toString()).getBytes("UTF-8");
            } else if (var1 instanceof Integer) {
               var3 = (g + ':' + ((Integer)var1).toString()).getBytes("UTF-8");
            } else if (var1 instanceof Long) {
               var3 = (h + ':' + ((Long)var1).toString()).getBytes("UTF-8");
            } else if (var1 instanceof String) {
               var3 = (i + ':' + (String)var1).getBytes("UTF-8");
            } else {
               var3 = var1.toString().getBytes("UTF-8");
            }

            var2 = this.z.c(var3, this.B);
         } catch (InvalidKeyException var4) {
            C.log(Level.SEVERE, MessageFormat.format("Can''t use the key stored in the {0} keystore; Either it is inappropriate for initializing the cipher, or its keysize exceeds the maximum allowable keysize", this.A));
         } catch (IllegalStateException var5) {
            C.log(Level.SEVERE, "Cipher is in a wrong state; Can't encrypt data");
         } catch (IllegalBlockSizeException var6) {
            C.log(Level.SEVERE, MessageFormat.format("Can''t encrypt the data: {0}", var6.getMessage()));
         } catch (BadPaddingException var7) {
         } catch (InvalidAlgorithmParameterException var8) {
            C.log(Level.SEVERE, "Can't initialize the algorithm parameters for the cipher");
         } catch (InvalidParameterSpecException var9) {
            C.log(Level.SEVERE, "Can't initialize the algorithm parameters for the cipher");
         } catch (NoSuchAlgorithmException var10) {
            C.log(Level.SEVERE, MessageFormat.format("Can''t handle the {0} algorithm; Either it is null, empty, in an invalid format, or no cipher implementation supports it", "AES"));
         } catch (NoSuchPaddingException var11) {
            C.log(Level.SEVERE, MessageFormat.format("A padding scheme has been specified in the {0} algorithm string but it can''t be handled", "AES"));
         } catch (UnsupportedEncodingException var12) {
            C.log(Level.SEVERE, MessageFormat.format("The {0} charset is not supported; Can''t encode data", "UTF-8"));
         }

         return var2;
      }
   }

   public Object a(String var1) {
      if (var1 == null) {
         return null;
      } else {
         try {
            byte[] var2 = this.b(var1);
            String var3 = w.a(var2);
            if ("byte[]".equals(var3)) {
               return Arrays.copyOfRange(var2, l.length + 1, var2.length);
            } else if (b.equals(var3)) {
               return Boolean.parseBoolean(new String(Arrays.copyOfRange(var2, m.length + 1, var2.length), "UTF-8"));
            } else if (c.equals(var3)) {
               return new Date(Long.parseLong(new String(Arrays.copyOfRange(var2, n.length + 1, var2.length), "UTF-8")));
            } else if (d.equals(var3)) {
               return new java.util.Date(Long.parseLong(new String(Arrays.copyOfRange(var2, o.length + 1, var2.length), "UTF-8")));
            } else if (e.equals(var3)) {
               return Double.parseDouble(new String(Arrays.copyOfRange(var2, p.length + 1, var2.length), "UTF-8"));
            } else if (f.equals(var3)) {
               return Float.parseFloat(new String(Arrays.copyOfRange(var2, q.length + 1, var2.length), "UTF-8"));
            } else if (g.equals(var3)) {
               return Integer.parseInt(new String(Arrays.copyOfRange(var2, r.length + 1, var2.length), "UTF-8"));
            } else if (h.equals(var3)) {
               return Long.parseLong(new String(Arrays.copyOfRange(var2, s.length + 1, var2.length), "UTF-8"));
            } else if (i.equals(var3)) {
               return new String(Arrays.copyOfRange(var2, t.length + 1, var2.length), "UTF-8");
            } else if (j.equals(var3)) {
               return new Time(Long.parseLong(new String(Arrays.copyOfRange(var2, u.length + 1, var2.length), "UTF-8")));
            } else {
               return k.equals(var3) ? new Timestamp(Long.parseLong(new String(Arrays.copyOfRange(var2, v.length + 1, var2.length), "UTF-8"))) : var2;
            }
         } catch (UnsupportedEncodingException var4) {
            C.log(Level.SEVERE, MessageFormat.format("The {0} charset is not supported", "UTF-8"));
            return null;
         }
      }
   }

   private byte[] b(String var1) {
      byte[] var2 = (byte[])null;

      try {
         var2 = this.z.a(var1, this.B);
      } catch (InvalidKeyException var4) {
         C.log(Level.SEVERE, MessageFormat.format("Can''t use the key stored in the {0} keystore; Either it is inappropriate for initializing the cipher, or its keysize exceeds the maximum allowable keysize", this.A));
      } catch (IllegalStateException var5) {
         C.log(Level.SEVERE, "Cipher is in a wrong state; Can't decrypt data");
      } catch (IllegalBlockSizeException var6) {
         C.log(Level.SEVERE, MessageFormat.format("Can''t decrypt the data: {0}", var6.getMessage()));
      } catch (BadPaddingException var7) {
         C.log(Level.SEVERE, "Can't decrypt the data: (un)padding has been requested, but the decrypted data is not bounded by the appropriate padding bytes");
      } catch (InvalidAlgorithmParameterException var8) {
         C.log(Level.SEVERE, "Can't initialize the algorithm parameters for the cipher");
      } catch (InvalidParameterSpecException var9) {
         C.log(Level.SEVERE, "Can't initialize the algorithm parameters for the cipher");
      } catch (NoSuchAlgorithmException var10) {
         C.log(Level.SEVERE, MessageFormat.format("Can''t handle the {0} algorithm; Either it is null, empty, in an invalid format, or no cipher implementation supports it", "AES"));
      } catch (NoSuchPaddingException var11) {
         C.log(Level.SEVERE, MessageFormat.format("A padding scheme has been specified in the {0} algorithm string but it can''t be handled", "AES"));
      } catch (UnsupportedEncodingException var12) {
         C.log(Level.SEVERE, MessageFormat.format("The {0} charset is not supported; Can''t decode data", "UTF-8"));
      }

      return var2;
   }
}
