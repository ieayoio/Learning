package cn.ieayoio.spring.spring022_01_SpringAOP_AspectJ01;

/**
 * Created by ieayoio on 16-9-7.
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext(
                "spring022_01_SpringAOP_AspectJ01.xml");

        CustomerBo customer = (CustomerBo) appContext.getBean("customerBo");
        customer.addCustomer();

        customer.addCustomerReturnValue();
    }
}