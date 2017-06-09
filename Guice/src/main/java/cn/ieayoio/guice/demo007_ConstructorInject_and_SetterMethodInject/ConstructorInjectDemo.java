package cn.ieayoio.guice.demo007_ConstructorInject_and_SetterMethodInject;

import com.google.inject.Guice;
import com.google.inject.Inject;

/**
 * Created by ieayoio on 16-8-3.
 */
public class ConstructorInjectDemo {


    // 这时如果再加上@Inject构造方法会被执行两遍
    private Service servcie;

    private HelloWorld helloWorld;

    public Service getServcie() {
        return servcie;
    }

    public HelloWorld getHelloWorld() {
        return helloWorld;
    }

    @Inject
    public ConstructorInjectDemo(Service service, HelloWorld helloWorld) {
        this.servcie = service;
        this.helloWorld = helloWorld;
    }

    public static void main(String[] args) {

        ConstructorInjectDemo demo = Guice.createInjector().getInstance(ConstructorInjectDemo.class);
        demo.getServcie().execute();
        demo.getHelloWorld().sayHello();
    }
}
