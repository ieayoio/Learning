package cn.ieayoio.guice.demo010_ProviderInject;

/**
 * Created by ieayoio on 16-8-3.
 */
public class ServiceImpl implements Service {
    @Override
    public void execute() {
        System.out.println("实现类的执行结果");
    }
}
