package ThinkingInJava.Annotation.UseAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//����Ԫע��
@Target(ElementType.METHOD) //�������ע���������ֵط�
@Retention(RetentionPolicy.RUNTIME) //��ע�����ĸ�������� Դ����(SOURCE)�����ļ�(CLASS)������ʱ(RUNTIME)
@interface UseCase {

    //ע���е�Ԫ��
    int id();
    String description() default "no description";

}
