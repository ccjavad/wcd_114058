package test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//1. Definieren:
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Version {
    int major();
    int minor();
}

//2. Anwenden:
@Version( major = 8, minor = 2 )
class Plugin {}


public class B02_definieren_anwenden_auswerten {

    public static void main(String[] args) throws Exception {
    
        //3. Auswerten:
        Class<Plugin> pluginClass = (Class<Plugin>)Class.forName("test.Plugin");
        
        Version v = pluginClass.getAnnotation(Version.class);
        
        if(v==null) {
            throw new IllegalStateException("Plugin-Version unbekannt");
        }
        
        if(v.major() < 3) {
            throw new IllegalStateException("Alte Plugin-Version wird nicht unterstützt");
        }
        
        System.out.println("v: " + v);
        System.out.println("v.major: " + v.major());
        
        Plugin pluginObj = pluginClass.newInstance();
        
    }
    
}
