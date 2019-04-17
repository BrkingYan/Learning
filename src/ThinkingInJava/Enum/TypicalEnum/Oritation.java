package ThinkingInJava.Enum.TypicalEnum;

import java.util.EnumSet;

public enum Oritation {
    WEST("west"),
    EAST("east"),
    NORTH("north"),
    SOUTH("south");

    private String description;

    /*
    默认构造器
    private Oritation(String s,int i){
        super(s,i);
    }
    */

    //自定义构造器
    Oritation(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    //toString()方法返回的是每个enum实例的"toString()",默认是每个实例的名字
    @Override
    public String toString() {
        return this.name() + "(" + this.ordinal() + ")";
    }



    public static void main(String[] args) {
        //用静态的values()方法获取所有枚举实例
        for (Oritation witch : Oritation.values()){
            System.out.println(witch + " : " + witch.getDescription());
        }

        // 用Class类的getEnumConstants()方法获取所有枚举实例
        Oritation e = Oritation.EAST; //EAST是Oritation类型的
        System.out.println("Oritation.class : "+Oritation.class);
        System.out.println("Oritation.EAST.getClass() :" + Oritation.EAST.getClass());
        Enum[] enums = e.getClass().getEnumConstants();
        for (Enum witch : enums){
            //System.out.println(witch + " : " + witch.getDescription());
            System.out.println(witch + " : " + witch.ordinal());
        }

        System.out.println(Integer.class.getEnumConstants() + "");


    }
}
