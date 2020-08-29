package javase高级.august29;



import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


import static java.lang.annotation.ElementType.TYPE_PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {TYPE_USE,TYPE_PARAMETER})
@interface MyAnnotation {
    String value() default "hello";
}
