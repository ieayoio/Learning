package cn.ieayoio.spring.spring004_JavaConfig_Import;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by ieayoio on 16-8-23.
 */
@Configuration
@Import({ CustomerConfig.class, SchedulerConfig.class })
public class AppConfig {

}
