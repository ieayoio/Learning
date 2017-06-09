package cn.ieayoio.guice.demo008_requestStaticInjection_and_requestInjection_etc;

import com.google.inject.ImplementedBy;

/**
 * Created by ieayoio on 16-8-3.
 */
@ImplementedBy(ServiceImpl.class)
public interface Service {
    void execute();
}
