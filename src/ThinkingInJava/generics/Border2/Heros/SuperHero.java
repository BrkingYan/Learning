package ThinkingInJava.generics.Border2.Heros;

import ThinkingInJava.generics.Border2.Powers.*;
public class SuperHero<T extends SuperPower> {  //���Ը���SuperPower�߱��ĳ�����
    T power;

    public SuperHero(T power){
        this.power = power;
    }

}
