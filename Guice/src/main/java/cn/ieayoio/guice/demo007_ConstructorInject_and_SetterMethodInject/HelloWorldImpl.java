package cn.ieayoio.guice.demo007_ConstructorInject_and_SetterMethodInject;

/**
 * Created by ieayoio on 16-8-3.
 */
public class HelloWorldImpl implements HelloWorld {

    public HelloWorldImpl(){
        System.out.println("HelloWorldImpl构造方法执行");
    }

    @Override
    public void sayHello() {
        System.out.println("HelloWorld在向你问候！");
    }
}
