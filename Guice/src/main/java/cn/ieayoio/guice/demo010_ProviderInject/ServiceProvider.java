package cn.ieayoio.guice.demo010_ProviderInject;

import com.google.inject.Provider;

/**
 * Created by ieayoio on 16-8-4.
 */
public class ServiceProvider implements Provider<Service> {

    @Override
    public Service get() {
        return new ServiceImpl();
    }
}
