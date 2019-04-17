package ThinkingInJava.Annotation.UseAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//两个元注解
@Target(ElementType.METHOD) //定义这个注解用在哪种地方
@Retention(RetentionPolicy.RUNTIME) //该注解在哪个级别可用 源代码(SOURCE)、类文件(CLASS)、运行时(RUNTIME)
@interface UseCase {

    //注解中的元素
    int id();
    String description() default "no description";

}
