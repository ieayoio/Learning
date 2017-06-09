package cn.ieayoio.guice.demo008_requestStaticInjection_and_requestInjection_etc;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Module;

/**
 * Created by ieayoio on 16-8-4.
 */
public class StaticFieldInjectDemo {

    @Inject
    public static Service service;

    public static void main(String[] args) {

        Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.requestStaticInjection(StaticFieldInjectDemo.class);
            }
        });

        StaticFieldInjectDemo.service.execute();




    }
}
