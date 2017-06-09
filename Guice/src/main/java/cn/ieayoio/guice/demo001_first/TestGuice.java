package cn.ieayoio.guice.demo001_first;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;

/**
 * Created by ieayoio on 16-8-2.
 */
public class TestGuice {

    @Test
    public void testHelloGuice() {
        Injector injector = Guice.createInjector(new HelloGuiceModule());

        HelloGuice helloGuice = injector.getInstance(HelloGuice.class);
        helloGuice.sayHello();
    }
}
