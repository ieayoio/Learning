package cn.ieayoio.spring.spring015_AtPostConstruct_AtPreDestroy;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ieayoio on 16-8-25.
 */
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext("spring015_AtPostConstruct_AtPreDestroy.xml");

        CustomerService cust = (CustomerService) context.getBean("customerService");

        System.out.println(cust);

        context.close();
    }
}