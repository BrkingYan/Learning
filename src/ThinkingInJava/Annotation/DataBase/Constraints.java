package ThinkingInJava.Annotation.DataBase;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Constraints {
    boolean isPrimaryKey() default false;
    boolean allowNull() default true;
    boolean unique() default false;
}
