package cn.ieayoio.guice.demo011_PropertiesInject;

import com.google.inject.*;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

import java.util.Properties;

/**
 * Created by ieayoio on 16-8-4.
 */
public class PropertiesDemo {

    @Inject
    @Named("thisweb")
    private String web;

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                Properties properties = new Properties();
                properties.setProperty("thisweb", "www.ieayoio.tk");
                Names.bindProperties(binder, properties);
            }
        });

        PropertiesDemo propertiesDemo = injector.getInstance(PropertiesDemo.class);

        System.out.println(propertiesDemo.web);
    }
}
