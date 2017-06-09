package cn.ieayoio.guice.demo011_PropertiesInject;

import cn.ieayoio.guice.demo010_ProviderInject.ServiceProvider;
import com.google.inject.ProvidedBy;

/**
 * Created by ieayoio on 16-8-3.
 */
@ProvidedBy(ServiceProvider.class)
public interface Service {
    void execute();
}
