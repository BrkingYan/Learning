package ThinkingInJava.Enum;

import static ThinkingInJava.Enum.Weather.*;//静态导入enmu

public class Test {

    private Weather weather;

    private Test(Weather weather){
        this.weather = weather;
    }

    public static void main(String[] args) {
        for (Color color : Color.values()){
            System.out.println(color + " ordinal : " + color.ordinal());
        }

        System.out.println(new Test(HOT));//静态导入，使其可以直接使用Weather enum中的实例

        System.out.println(EnumRandomUtil.getRandomEnumMember(Color.class));
    }
}

