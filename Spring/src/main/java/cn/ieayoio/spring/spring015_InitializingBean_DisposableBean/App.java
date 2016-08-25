package cn.ieayoio.spring.spring015_InitializingBean_DisposableBean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ieayoio on 16-8-25.
 */
public class App
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"spring015_InitializingBean_DisposableBean.xml"});

        CustomerService cust = (CustomerService)context.getBean("customerService");

        System.out.println(cust);

        context.close();
    }
}