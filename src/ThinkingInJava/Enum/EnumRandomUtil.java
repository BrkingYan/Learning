package ThinkingInJava.Enum;

import java.util.Random;

/*
*  枚举工具类
* */
public class EnumRandomUtil {
    private static Random rand = new Random();

    /*
    *  该方法根据枚举类型产生随机的枚举实例
    * */
    public static <T extends Enum<T>> T getRandomEnumMember(Class<T> enumType){
        return selectRandom(enumType.getEnumConstants());
    }

    /*
    *  该方法根据枚举类的values数组，用random随机产生一个数组中的枚举实例
    * */
    public static <T> T selectRandom(T[] values){
        return values[rand.nextInt(values.length)];
    }
}
