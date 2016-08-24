package cn.ieayoio.spring.spring009_collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ieayoio on 16-8-24.
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring009_collections.xml");

        Customer cust = (Customer) context.getBean("CustomerBean");
        System.out.println(cust.getPros());

    }
}
