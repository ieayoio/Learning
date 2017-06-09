package cn.ieayoio.guice.demo002_ImplementedBy;

import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * Created by ieayoio on 16-8-2.
 */
@Deprecated
public class HelloGuiceModule implements Module {

    public HelloGuiceModule() {
        System.out.println("通过Module注入");
    }

    public void configure(Binder binder) {
        binder.bind(HelloGuice.class).to(HelloGuiceImpl.class);
    }
}
