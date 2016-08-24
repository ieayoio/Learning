package cn.ieayoio.spring.spring008_Automatic_scanning;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ieayoio on 16-8-24.
 */
public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"spring008_Automatic_scanning.xml"});

        CustomerService custA = (CustomerService)context.getBean("customerService");
        custA.setMessage("Message by custA");
        System.out.println("Message : " + custA.getMessage());

        //retrieve it again
        CustomerService custB = (CustomerService)context.getBean("customerService");
        System.out.println("Message : " + custB.getMessage());
    }
}
