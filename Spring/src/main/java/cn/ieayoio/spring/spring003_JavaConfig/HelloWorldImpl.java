package cn.ieayoio.spring.spring003_JavaConfig;

/**
 * Created by ieayoio on 16-8-23.
 */
public class HelloWorldImpl implements HelloWorld {

    @Override
    public void printHelloWorld(String msg) {

        System.out.println("Hello : " + msg);
    }

}