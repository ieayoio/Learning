package cn.ieayoio.spring.spring005_DI_Setter;

/**
 * Created by ieayoio on 16-8-23.
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring005_DI_Constructor.xml");
        OutputHelper output = (OutputHelper) context.getBean("OutputHelper");
        output.generateOutput();
    }
}
