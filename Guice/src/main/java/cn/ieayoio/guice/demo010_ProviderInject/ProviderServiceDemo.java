package cn.ieayoio.guice.demo010_ProviderInject;

import com.google.inject.Guice;
import com.google.inject.Inject;

/**
 * Created by ieayoio on 16-8-4.
 */
public class ProviderServiceDemo {

    @Inject
    private Service service;

    public static void main(String[] args) {

        // 普通的绑定可以参见demo005_toProvider

        ProviderServiceDemo providerServiceDemo = Guice.createInjector().getInstance(ProviderServiceDemo.class);

        providerServiceDemo.service.execute();

    }

}
