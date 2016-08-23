package cn.ieayoio.spring.spring004_JavaConfig_Import;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ieayoio on 16-8-23.
 */
@Configuration
public class CustomerConfig {

    @Bean(name="customer")
    public CustomerBo customerBo(){

        return new CustomerBo();

    }
}
