package cn.ieayoio.spring.spring003_JavaConfig;

/**
 * Created by ieayoio on 16-8-23.
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld obj = (HelloWorld) context.getBean("helloBea");

        obj.printHelloWorld("ieayoio");

    }
}
