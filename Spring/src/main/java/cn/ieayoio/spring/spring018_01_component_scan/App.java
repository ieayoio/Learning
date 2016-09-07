package cn.ieayoio.spring.spring018_01_component_scan;

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
                new ClassPathXmlApplicationContext(new String[] {"spring018_01_component_scan.xml"});

        CustomerService cust = (CustomerService)context.getBean("sfdsfdfdf");
        System.out.println(cust);

    }
}