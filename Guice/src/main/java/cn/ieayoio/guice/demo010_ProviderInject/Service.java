package cn.ieayoio.guice.demo010_ProviderInject;

import com.google.inject.ProvidedBy;

/**
 * Created by ieayoio on 16-8-3.
 */
@ProvidedBy(ServiceProvider.class)
public interface Service {
    void execute();
}
