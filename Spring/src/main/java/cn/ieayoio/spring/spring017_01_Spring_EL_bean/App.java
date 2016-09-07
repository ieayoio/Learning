package cn.ieayoio.spring.spring017_01_Spring_EL_bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ieayoio on 16-9-7.
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring017_01_Spring_EL_bean.xml");

        Customer obj = (Customer) context.getBean("customerBean");
        System.out.println(obj);
    }
}