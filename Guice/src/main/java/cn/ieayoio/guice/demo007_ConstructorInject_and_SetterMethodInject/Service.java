package cn.ieayoio.guice.demo007_ConstructorInject_and_SetterMethodInject;

import com.google.inject.ImplementedBy;

/**
 * Created by ieayoio on 16-8-3.
 */
@ImplementedBy(ServiceImpl.class)
public interface Service {
    void execute();
}
