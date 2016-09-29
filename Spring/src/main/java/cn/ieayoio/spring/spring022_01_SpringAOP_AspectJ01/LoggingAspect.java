package cn.ieayoio.spring.spring022_01_SpringAOP_AspectJ01;

/**
 * Created by ieayoio on 16-9-29.
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution( * cn.ieayoio.spring.spring022_01_SpringAOP_AspectJ01.CustomerBo.addCustomer(..))")
    public void logBefore(JoinPoint joinPoint) {

        System.out.println("logBefore() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("******");
    }

    @After("execution(* cn.ieayoio.spring.spring022_01_SpringAOP_AspectJ01.CustomerBo.addCustomer(..))")
    public void logAfter(JoinPoint joinPoint) {

        System.out.println("logAfter() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("******");

    }

    @AfterReturning(
            pointcut = "execution(* cn.ieayoio.spring.spring022_01_SpringAOP_AspectJ01.CustomerBo.addCustomerReturnValue(..))",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result /* result 变量名和returning的值必须相同 */) {

        System.out.println("logAfterReturning() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("Method returned value is : " + result);
        System.out.println("******");
    }


}