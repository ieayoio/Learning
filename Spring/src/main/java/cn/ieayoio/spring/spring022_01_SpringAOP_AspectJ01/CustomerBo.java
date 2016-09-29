package cn.ieayoio.spring.spring022_01_SpringAOP_AspectJ01;

/**
 * Created by ieayoio on 16-9-29.
 */
public interface CustomerBo {

    void addCustomer();

    String addCustomerReturnValue();

    void addCustomerThrowException() throws Exception;

    void addCustomerAround(String name);
}