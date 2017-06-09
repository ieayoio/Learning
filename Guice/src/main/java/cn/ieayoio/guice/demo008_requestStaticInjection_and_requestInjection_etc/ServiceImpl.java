package cn.ieayoio.guice.demo008_requestStaticInjection_and_requestInjection_etc;

/**
 * Created by ieayoio on 16-8-3.
 */
public class ServiceImpl implements Service {

    public ServiceImpl(){
        System.out.println("ServiceImpl构造方法方法被执行");
    }

    @Override
    public void execute() {
        System.out.println("Service实现来类的执行结果");
    }
}
