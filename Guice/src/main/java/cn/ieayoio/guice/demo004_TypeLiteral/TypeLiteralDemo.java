package cn.ieayoio.guice.demo004_TypeLiteral;

import com.google.inject.TypeLiteral;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ieayoio on 16-8-2.
 */
public class TypeLiteralDemo {

    public static void main(String[] args) throws NoSuchMethodException {

        //
        System.out.println(String.format("guice type:%s", TypeLiteral.get(Boolean.class)));
        System.out.println(String.format("java type:%s", Boolean.class));
        System.out.println(1);
        //
        System.out.println(String.format("guice type:%s", TypeLiteral.get(int.class)));
        System.out.println(String.format("java type:%s", int.class));
        System.out.println(2);
        //
        System.out.println(String.format("guice type:%s", new TypeLiteral<Map<Integer, String>>(){}));
        System.out.println(String.format("java type:%s", new HashMap<Integer,String>().getClass()));
        System.out.println(3);
        //
        Method m = Map.class.getMethod("keySet", new Class[0]);
        System.out.println(String.format("java type:%s", m.getReturnType()));
        System.out.println(String.format("java generic type:%s", m.getGenericReturnType()));
        System.out.println(String.format("guice type:%s", TypeLiteral.get(m.getGenericReturnType())));
        System.out.println(4);
        TypeLiteral<Map<Integer, String>> mapType = new TypeLiteral<Map<Integer, String>>() {};
        System.out.println(String.format("guice type:%s", mapType.getReturnType(m)));
    }
}
