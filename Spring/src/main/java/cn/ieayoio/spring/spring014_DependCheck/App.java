package cn.ieayoio.spring.spring014_DependCheck;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ieayoio on 16-8-25.
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring014_DependCheck.xml");

        Customer customerBean1 = (Customer) context.getBean("CustomerBean1");
        System.out.println(customerBean1);

        Customer customerBean2 = (Customer) context.getBean("CustomerBean2");
        System.out.println(customerBean2);

        Customer CustomerBean3 = (Customer) context.getBean("CustomerBean3");
        System.out.println(CustomerBean3);

        Customer CustomerBean4 = (Customer) context.getBean("CustomerBean4");
        System.out.println(CustomerBean4);
    }
}
