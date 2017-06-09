package cn.ieayoio.guice.demo007_ConstructorInject_and_SetterMethodInject;

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
