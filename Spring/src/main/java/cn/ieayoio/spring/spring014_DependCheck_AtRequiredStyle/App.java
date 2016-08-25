package cn.ieayoio.spring.spring014_DependCheck_AtRequiredStyle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ieayoio on 16-8-25.
 */
public class App {

    // TODO: 16-8-25 虽然这样添加@Mandatory没解决依赖检查会报错，但是仍然可以被执行，不会有异常抛出
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring014_DependCheck_AtRequiredStyle.xml");

        Object customerBean = context.getBean("CustomerBean");

        System.out.println(customerBean);

    }

}
