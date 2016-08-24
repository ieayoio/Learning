package cn.ieayoio.spring.spring008_Automatic_scanning;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by ieayoio on 16-8-24.
 */
@Service
@Scope("singleton")
public class CustomerService
{
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
