package cn.ieayoio.spring.spring003_JavaConfig;

import org.springframework.context.annotation.Bean;

/**
 * Created by ieayoio on 16-8-23.
 */
// 不写这个注解也没有报错
//@Configuration
public class AppConfig {

    @Bean(name="helloBea")
    public HelloWorld helloWorld() {
        return new HelloWorldImpl();
    }

}
