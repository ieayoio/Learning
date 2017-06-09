package cn.ieayoio.guice.demo009_AnnotationInject;

/**
 * Created by ieayoio on 16-8-4.
 */
public class HomeService implements Service {
    @Override
    public void execute() {
        System.out.println("我是HomeService的实现");
    }
}
