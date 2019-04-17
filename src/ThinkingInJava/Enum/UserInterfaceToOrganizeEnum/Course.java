package ThinkingInJava.Enum.UserInterfaceToOrganizeEnum;

import ThinkingInJava.Enum.EnumRandomUtil;

import java.util.Random;

/*
*  һ��������ɲ˵���ϵͳ
* */
enum  Course {
    Dessert(Food.Dessert.class),
    Beverage(Food.Beverage.class),
    MainFood(Food.MainFood.class);
    private Food[] values;
    private static Random rand = new Random();

    //�Զ��幹�������ù������ᱻ�������Զ�����
    private Course(Class<? extends Food> foodType){
        values = foodType.getEnumConstants();
    }


    Food randomSelection(){
        return EnumRandomUtil.selectRandom(values);
    }

    public static void main(String[] args) {
        for (int i = 0;i< 5 ;i++){
            System.out.println("recipe " + (i+1));
            for (Course course : Course.values()){
                Food food = course.randomSelection();
                System.out.println(food);
            }
            System.out.println("------------");
        }
    }
}
