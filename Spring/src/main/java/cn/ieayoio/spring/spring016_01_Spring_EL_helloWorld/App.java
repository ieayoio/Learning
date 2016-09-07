package cn.ieayoio.spring.spring016_01_Spring_EL_helloWorld;

/**
 * Created by ieayoio on 16-9-7.
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring016_01_Spring_EL_helloWorld.xml");

        Customer obj = (Customer) context.getBean("customerBean");
        System.out.println(obj);
    }
}