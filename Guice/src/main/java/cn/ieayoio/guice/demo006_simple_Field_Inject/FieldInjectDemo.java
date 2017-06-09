package cn.ieayoio.guice.demo006_simple_Field_Inject;

import com.google.inject.Guice;
import com.google.inject.Inject;

/**
 * Created by ieayoio on 16-8-3.
 */
public class FieldInjectDemo {

    @Inject
    private Service servcie;

    public Service getServcie() {
        return servcie;
    }

    public static void main(String[] args) {

        // Guice.createInjector()过后自动实现servcie
        FieldInjectDemo demo = Guice.createInjector().getInstance(FieldInjectDemo.class);
        demo.getServcie().execute();
    }
}
