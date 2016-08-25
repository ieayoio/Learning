package cn.ieayoio.spring.spring015_Init_method_destroy_method;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ieayoio on 16-8-25.
 */
public class App
{
    public static void main( String[] args )
    {
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"spring015_Init_method_destroy_method.xml"});

        CustomerService cust = (CustomerService)context.getBean("customerService");

        System.out.println(cust);

        context.close();
    }
}