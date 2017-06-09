package cn.ieayoio.guice.demo002_ImplementedBy;

import com.google.inject.ImplementedBy;

/**
 * Created by ieayoio on 16-8-2.
 */
@ImplementedBy(HelloGuiceImpl.class)
public interface HelloGuice {
    public void sayHello();
}