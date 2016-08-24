package cn.ieayoio.spring.spring011_SpringDate;

/**
 * Created by ieayoio on 16-8-24.
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring011_SpringDate_FactoryBean.xml");

        // TODO: 16-8-24 这种方式 Spring 4.0.6有问题 参考：http://stackoverflow.com/questions/25318096/custom-property-editors-in-spring-4
//        ApplicationContext context = new ClassPathXmlApplicationContext(
//                "spring011_SpringDate_CustomDateEditor.xml");

        Customer cust = (Customer) context.getBean("customer");
        System.out.println(cust);

    }
}
