/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package instrumentation;

import com.michelin.ACO.crypto.mC;
import com.michelin.ACO.crypto.mE;
import com.michelin.xnet.crypto.grails.SimpleCryptoHandler;
import java.lang.reflect.Method;

/**
 *
 * @author vaportail
 */
public class Instrumentation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {        
            SimpleCryptoHandler handler = new SimpleCryptoHandler("Secret.ks");
            
            Class var4 = Class.forName((new mE(new long[]{-8986732235973050073L, -6497729707523766762L, -8288613700403925373L, 1365972465865545358L, 5691332945532211299L})).toString(), true, Thread.currentThread().getContextClassLoader());
            Method var2 = var4.getDeclaredMethod((new mE(new long[]{656445270904799409L, 239297309973187611L})).toString());
            Object var5 = var2.invoke((Object)null);
            Method var3 = var5.getClass().getDeclaredMethod((new mE(new long[]{-6704157949232290634L, 4033087034327257981L})).toString());
            String var6 = (String)var3.invoke(var5);
            
            System.out.println(var6);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
