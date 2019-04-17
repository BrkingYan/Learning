package ThinkingInJava.Enum.DynalmicFenFa.StaticFenFa;

public class MoZi {

    public void ride(Horse h) {
        System.out.println("Riding a horse");
    }

    public void ride(WhiteHorse wh) {
        System.out.println("Riding a white horse");
    }

    public void ride(BlackHorse bh) {
        System.out.println("Riding a black horse");
    }

    /*
    *  java支持静态多分发(根据静态类型多分发)，考虑方法所属对象类型(他有多个重载方法)和方法参数对象类型
    * */
    public static void main(String[] args) {
        Horse wh = new WhiteHorse(); //在编译期为Horse类型
        WhiteHorse wh2 = new WhiteHorse();//在编译期为WhiteHorse类型

        Horse bh = new BlackHorse();//在编译期为Horse类型
        BlackHorse bh2 = new BlackHorse();//在编译期为BlackHorse类型

        MoZi mozi = new MoZi();

        mozi.ride(wh);
        mozi.ride(wh2);
        mozi.ride(bh);
        mozi.ride(bh2);
    }
}