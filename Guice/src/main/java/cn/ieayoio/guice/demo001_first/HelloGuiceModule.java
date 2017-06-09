package cn.ieayoio.guice.demo001_first;

import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * Created by ieayoio on 16-8-2.
 */
public class HelloGuiceModule implements Module {
    public void configure(Binder binder) {
        binder.bind(HelloGuice.class).to(HelloGuiceImpl.class);
    }
}
