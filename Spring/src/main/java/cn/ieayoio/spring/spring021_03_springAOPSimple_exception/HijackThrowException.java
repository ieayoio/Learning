package cn.ieayoio.spring.spring021_03_springAOPSimple_exception;

/**
 * Created by ieayoio on 16-9-7.
 */
import org.springframework.aop.ThrowsAdvice;

public class HijackThrowException implements ThrowsAdvice
{
    // 这里居然不用重写父方法
    public void afterThrowing(IllegalArgumentException e) throws Throwable {
        System.out.println("HijackThrowException : Throw exception hijacked!");
    }

}