package ThinkingInJava.Enum.EnumEnum;

import ThinkingInJava.Enum.EnumRandomUtil;

import java.util.EnumSet;

enum School {
    //School的values里面装了这两个
    //枚举实例是通过其所属枚举的构造器初始化的，当其所属实例的构造器被自定义时，每个实例可以选择不同的初始化参数
    NAMES(Person.Name.class), AGES(Person.Age.class);

    /*
    * static
    {
        NAMES = new School("NAMES", 0, ThinkingInJava/Enum/EnumEnum/School$Person$Name);
        AGES = new School("AGES", 1, ThinkingInJava/Enum/EnumEnum/School$Person$Age);
        $VALUES = (new School[] {
            NAMES, AGES
        });
    }
    * */

    //School还持有Person类型的values
    Person[] values;

    // School的构造器，可以传入别的类型，并获取Person类型中的枚举
    School(Class<? extends Person> kind){
        values = kind.getEnumConstants();
    }

    Person getRandomPerson(){
        return EnumRandomUtil.selectRandom(values);//在Person[]类型的 values数组中随机选一个Person类型
    }

    interface Person{
        enum Name implements Person{JACK,BOB,MIKE}
        enum Age implements Person{ONE,TWO,THREE}
    }
}
