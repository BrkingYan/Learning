package ThinkingInJava.Enum;

import java.util.Random;

/*
*  ö�ٹ�����
* */
public class EnumRandomUtil {
    private static Random rand = new Random();

    /*
    *  �÷�������ö�����Ͳ��������ö��ʵ��
    * */
    public static <T extends Enum<T>> T getRandomEnumMember(Class<T> enumType){
        return selectRandom(enumType.getEnumConstants());
    }

    /*
    *  �÷�������ö�����values���飬��random�������һ�������е�ö��ʵ��
    * */
    public static <T> T selectRandom(T[] values){
        return values[rand.nextInt(values.length)];
    }
}
