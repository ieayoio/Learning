package cn.ieayoio.spring.spring015_AtPostConstruct_AtPreDestroy;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by ieayoio on 16-8-25.
 */
public class CustomerService
{
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @PostConstruct
    public void initIt() throws Exception {
        System.out.println("Init method after properties are set : " + message);
    }

    @PreDestroy
    public void cleanUp() throws Exception {
        System.out.println("Spring Container is destroy! Customer clean up");
    }

}