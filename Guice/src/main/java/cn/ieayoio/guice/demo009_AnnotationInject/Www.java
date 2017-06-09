package cn.ieayoio.guice.demo009_AnnotationInject;

import com.google.inject.BindingAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

/**
 * Created by ieayoio on 16-8-4.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD,PARAMETER})
@BindingAnnotation
public @interface Www {
}
