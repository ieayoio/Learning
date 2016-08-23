package cn.ieayoio.spring.spring004_JavaConfig_Import;

/**
 * Created by ieayoio on 16-8-23.
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(
                AppConfig.class);

        CustomerBo customer = (CustomerBo) context.getBean("customer");
        customer.printMsg("Hello 11");

        SchedulerBo scheduler = (SchedulerBo) context.getBean("scheduler");
        scheduler.printMsg("Hello 22");

    }
}
/**
 * 发现@Configuration可以完全不写
 */
