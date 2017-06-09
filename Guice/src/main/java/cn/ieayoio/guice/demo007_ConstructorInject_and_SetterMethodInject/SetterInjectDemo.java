package cn.ieayoio.guice.demo007_ConstructorInject_and_SetterMethodInject;

import com.google.inject.Guice;
import com.google.inject.Inject;

/**
 * Created by ieayoio on 16-8-4.
 */
public class SetterInjectDemo {

    private Service service;

    @Inject
    public void setService(Service service) {
        this.service = service;
    }

    public Service getService() {
        return service;
    }

    public static void main(String[] args) {

        SetterInjectDemo sid = Guice.createInjector().getInstance(SetterInjectDemo.class);

        sid.getService().execute();

    }
}
