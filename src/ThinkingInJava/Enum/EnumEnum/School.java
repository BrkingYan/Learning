package ThinkingInJava.Enum.EnumEnum;

import ThinkingInJava.Enum.EnumRandomUtil;

import java.util.EnumSet;

enum School {
    //School��values����װ��������
    //ö��ʵ����ͨ��������ö�ٵĹ�������ʼ���ģ���������ʵ���Ĺ��������Զ���ʱ��ÿ��ʵ������ѡ��ͬ�ĳ�ʼ������
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

    //School������Person���͵�values
    Person[] values;

    // School�Ĺ����������Դ��������ͣ�����ȡPerson�����е�ö��
    School(Class<? extends Person> kind){
        values = kind.getEnumConstants();
    }

    Person getRandomPerson(){
        return EnumRandomUtil.selectRandom(values);//��Person[]���͵� values���������ѡһ��Person����
    }

    interface Person{
        enum Name implements Person{JACK,BOB,MIKE}
        enum Age implements Person{ONE,TWO,THREE}
    }
}
