package cn.ieayoio.spring.spring013_inheritance;

/**
 * Created by ieayoio on 16-8-24.
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring013_inheritance.xml");

        Customer cust = (Customer)context.getBean("CustomerBean");

        System.out.println(cust);

    }
}
