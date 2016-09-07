package cn.ieayoio.spring.spring019_01_auto_wiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ieayoio on 16-9-7.
 */
public class App {

    public static void main(String[] args) {

        // 详细 http://www.yiibai.com/spring/spring-autowiring-by-name.html

        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"spring019_01_auto_wiring.xml"});

        Customer customer = (Customer) context.getBean("customer");
        System.out.println(customer);

    }
}
