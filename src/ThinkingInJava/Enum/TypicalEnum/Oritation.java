package ThinkingInJava.Enum.TypicalEnum;

import java.util.EnumSet;

public enum Oritation {
    WEST("west"),
    EAST("east"),
    NORTH("north"),
    SOUTH("south");

    private String description;

    /*
    Ĭ�Ϲ�����
    private Oritation(String s,int i){
        super(s,i);
    }
    */

    //�Զ��幹����
    Oritation(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    //toString()�������ص���ÿ��enumʵ����"toString()",Ĭ����ÿ��ʵ��������
    @Override
    public String toString() {
        return this.name() + "(" + this.ordinal() + ")";
    }



    public static void main(String[] args) {
        //�þ�̬��values()������ȡ����ö��ʵ��
        for (Oritation witch : Oritation.values()){
            System.out.println(witch + " : " + witch.getDescription());
        }

        // ��Class���getEnumConstants()������ȡ����ö��ʵ��
        Oritation e = Oritation.EAST; //EAST��Oritation���͵�
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
