package cn.ieayoio.guice.demo006_simple_Field_Inject;

import com.google.inject.ImplementedBy;

/**
 * Created by ieayoio on 16-8-3.
 */
@ImplementedBy(ServiceImpl.class)
public interface Service {
    void execute();
}
