package ThinkingInJava.Annotation.DataBase;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface SQLString {
    int value() default 0;
    String name() default "";
    Constraints constraints() default @Constraints;
}
