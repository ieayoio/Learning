package cn.ieayoio.guice.demo002_ImplementedBy;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;

/**
 * Created by ieayoio on 16-8-2.
 */
public class TestGuice {

    @Test
    public void testHelloGuice() {

//        // 以往的注入方式
//        Injector injector = Guice.createInjector(new HelloGuiceModule());

        Injector injector = Guice.createInjector();
        HelloGuice helloGuice = injector.getInstance(HelloGuice.class);
        helloGuice.sayHello();
    }
}
