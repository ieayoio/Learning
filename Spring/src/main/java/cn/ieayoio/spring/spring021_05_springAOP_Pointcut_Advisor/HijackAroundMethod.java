package cn.ieayoio.spring.spring021_05_springAOP_Pointcut_Advisor;

/**
 * Created by ieayoio on 16-9-7.
 */

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Arrays;

public class HijackAroundMethod implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        System.out.println("Method name : "
                + methodInvocation.getMethod().getName());
        System.out.println("Method arguments : "
                + Arrays.toString(methodInvocation.getArguments()));

        System.out.println("HijackAroundMethod : Before method hijacked!");

        try {
            Object result = methodInvocation.proceed();
            System.out.println("HijackAroundMethod : Before after hijacked!");

            return result;

        } catch (IllegalArgumentException e) {

            System.out.println("HijackAroundMethod : Throw exception hijacked!");
            throw e;
        }
    }
}