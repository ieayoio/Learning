package cn.ieayoio.guice.demo002_ImplementedBy;

/**
 * Created by ieayoio on 16-8-2.
 */
public class HelloGuiceImpl implements HelloGuice {
    public void sayHello() {
        System.out.println("Hello Guice!");
    }
}
