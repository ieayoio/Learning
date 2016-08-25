package cn.ieayoio.spring.spring014_DependCheck_AtRequired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ieayoio on 16-8-25.
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring014_DependCheck_AtRequired.xml");

        Object customerBean = context.getBean("CustomerBean");

        System.out.println(customerBean);

    }
}