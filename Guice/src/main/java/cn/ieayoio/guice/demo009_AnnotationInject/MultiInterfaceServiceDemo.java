package cn.ieayoio.guice.demo009_AnnotationInject;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * Created by ieayoio on 16-8-4.
 */
public class MultiInterfaceServiceDemo {

    @Inject
    @Www
    private Service wwwService;

    @Inject
    @Home
    private Service homeService;

    public static void main(String[] args) {

        Injector injector = Guice.createInjector((Module) binder -> {

            binder.bind(Service.class).annotatedWith(Www.class).to(WwwService.class);
            binder.bind(Service.class).annotatedWith(Home.class).to(HomeService.class);
        });

        MultiInterfaceServiceDemo misd = injector.getInstance(MultiInterfaceServiceDemo.class);

        misd.homeService.execute();
        misd.wwwService.execute();

    }
}
