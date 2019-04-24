package ThinkingInJava.Annotation.DataBase2;

import java.lang.annotation.*;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Table {
    String tableName() default "";
}
