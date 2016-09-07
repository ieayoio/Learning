package cn.ieayoio.spring.spring018_01_component_scan;

/**
 * Created by ieayoio on 16-9-7.
 */
import org.springframework.stereotype.Component;

@Component("sdf")
public class CustomerDAO
{
    @Override
    public String toString() {
        return "Hello , This is CustomerDAO";
    }
}