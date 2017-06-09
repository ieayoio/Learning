package cn.ieayoio.guice.demo005_toProvider;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import org.junit.Test;

/**
 * Created by ieayoio on 16-8-2.
 */
public class TestGuice {

    @Test
    public void testHelloGuice() {
        Injector injector1 = Guice.createInjector((Module) binder -> binder.bind(HelloGuice.class).toProvider(() -> new HelloGuiceImpl1()));

        HelloGuice helloGuice1 = injector1.getInstance(HelloGuice.class);
        helloGuice1.sayHello();


        Injector injector2 = Guice.createInjector((Module) binder -> binder.bind(HelloGuice.class).toProvider(() -> new HelloGuiceImpl2()));

        HelloGuice helloGuice2 = injector2.getInstance(HelloGuice.class);
        helloGuice2.sayHello();
    }
}
