package cn.ieayoio.spring.spring021_02_springAOPSimple_after;

/**
 * Created by ieayoio on 16-9-7.
 */
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class HijackBeforeMethod implements AfterReturningAdvice
{

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("HijackAfterMethod : After method hijacked!");
    }
}