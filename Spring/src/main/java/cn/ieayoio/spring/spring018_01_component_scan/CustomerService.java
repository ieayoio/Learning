package cn.ieayoio.spring.spring018_01_component_scan;

/**
 * Created by ieayoio on 16-9-7.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sfdsfdfdf")
public class CustomerService
{
    @Autowired
    CustomerDAO customerDAO;

    @Override
    public String toString() {
        return "CustomerService [customerDAO=" + customerDAO + "]";
    }
}