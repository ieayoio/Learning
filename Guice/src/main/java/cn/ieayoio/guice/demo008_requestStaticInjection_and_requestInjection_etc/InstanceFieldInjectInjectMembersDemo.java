package cn.ieayoio.guice.demo008_requestStaticInjection_and_requestInjection_etc;

import com.google.inject.Guice;
import com.google.inject.Inject;

/**
 * Created by ieayoio on 16-8-4.
 */
public class InstanceFieldInjectInjectMembersDemo {

    @Inject
    private Service service;

    public static void main(String[] args) {

        InstanceFieldInjectInjectMembersDemo ifid = new InstanceFieldInjectInjectMembersDemo();

        // 为实例注入
        Guice.createInjector().injectMembers(ifid);

        ifid.service.execute();
    }
}
