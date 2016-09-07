package cn.ieayoio.spring.spring019_02_auto_wiring_AtAutowired;

/**
 * Created by ieayoio on 16-9-7.
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"spring019_02_auto_wiring_AtAutowired.xml"});

        Customer cust = (Customer)context.getBean("CustomerBean");
        System.out.println(cust);

    }
}