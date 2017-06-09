package cn.ieayoio.guice.demo008_requestStaticInjection_and_requestInjection_etc;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Module;

/**
 * Created by ieayoio on 16-8-4.
 */
public class InstanceFieldInjectDemo {

    @Inject
    private Service service;

    public static void main(String[] args) {

        final InstanceFieldInjectDemo ifid = new InstanceFieldInjectDemo();
        Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.requestInjection(ifid);
            }
        });

        ifid.service.execute();
    }
}
