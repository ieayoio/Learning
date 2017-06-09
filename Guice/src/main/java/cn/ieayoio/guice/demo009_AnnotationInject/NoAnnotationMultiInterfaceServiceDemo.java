package cn.ieayoio.guice.demo009_AnnotationInject;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

/**
 * Created by ieayoio on 16-8-4.
 */
public class NoAnnotationMultiInterfaceServiceDemo {

    @Inject
    @Named("MyWww")
    private Service wwwService;

    @Inject
    @Named("MyHome")
    private Service homeService;

    public static void main(String[] args) {

        NoAnnotationMultiInterfaceServiceDemo serviceDemo =new NoAnnotationMultiInterfaceServiceDemo();

        Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {

                binder.bind(Service.class).annotatedWith(Names.named("MyWww")).to(WwwService.class);
                binder.bind(Service.class).annotatedWith(Names.named("MyHome")).to(HomeService.class);
            }
        })
                // 参考demo008_requestStaticInjection_and_requestInjection_etc中InstanceFieldInjectInjectMembersDemo
                .injectMembers(serviceDemo);

        serviceDemo.wwwService.execute();
        serviceDemo.homeService.execute();

    }
}
