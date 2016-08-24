package cn.ieayoio.spring.spring012_PropertyPlaceholderConfigurer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ieayoio on 16-8-24.
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring012_PropertyPlaceholderConfigurer.xml");

        DriverManagerDataSource dataSource = (DriverManagerDataSource) context.getBean("dataSource");

        System.out.println(dataSource);


    }
}
