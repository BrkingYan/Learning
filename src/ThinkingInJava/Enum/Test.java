package ThinkingInJava.Enum;

import static ThinkingInJava.Enum.Weather.*;//��̬����enmu

public class Test {

    private Weather weather;

    private Test(Weather weather){
        this.weather = weather;
    }

    public static void main(String[] args) {
        for (Color color : Color.values()){
            System.out.println(color + " ordinal : " + color.ordinal());
        }

        System.out.println(new Test(HOT));//��̬���룬ʹ�����ֱ��ʹ��Weather enum�е�ʵ��

        System.out.println(EnumRandomUtil.getRandomEnumMember(Color.class));
    }
}

