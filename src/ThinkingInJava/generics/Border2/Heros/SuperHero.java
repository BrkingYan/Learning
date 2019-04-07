package ThinkingInJava.generics.Border2.Heros;

import ThinkingInJava.generics.Border2.Powers.*;
public class SuperHero<T extends SuperPower> {  //可以给他SuperPower具备的超能力
    T power;

    public SuperHero(T power){
        this.power = power;
    }

}
