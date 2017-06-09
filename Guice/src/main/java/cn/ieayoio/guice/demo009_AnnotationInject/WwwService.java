package cn.ieayoio.guice.demo009_AnnotationInject;

/**
 * Created by ieayoio on 16-8-4.
 */
public class WwwService implements Service {
    @Override
    public void execute() {
        System.out.println("我是WwwService的实现");
    }
}
