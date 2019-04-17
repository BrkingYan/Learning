package ThinkingInJava.Annotation.UseAnnotation;


import java.lang.reflect.*;
import java.util.*;

class UseCaseTracker {
    void trackUseCases(List<Integer> useCases,Class<?> trackedClass){
        /*
        *  ���÷����ȡ���еķ��������������÷����жϷ����Ƿ�ʹ��ĳ��ע��
        * */
        for (Method method : trackedClass.getDeclaredMethods()){
            UseCase useCase = method.getAnnotation(UseCase.class);
            if (useCase != null){
                System.out.println("found use case : " + useCase.id() + "  " + useCase.description());
                useCases.remove(new Integer(useCase.id()));
            }
        }

        for (Field field : trackedClass.getDeclaredFields()){
            FieldAnnotation fieldAnnotation = field.getAnnotation(FieldAnnotation.class);
            if (fieldAnnotation != null){
                System.out.println("found field annotation : " + fieldAnnotation.fieldId() + " " + fieldAnnotation.description());
            }
        }

        for (int i : useCases){
            System.out.println("Warning : Missing use case-" + i);
        }
    }
}
