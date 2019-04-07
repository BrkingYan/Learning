package ThinkingInJava.generics.Border2.Heros;

import ThinkingInJava.generics.Border2.Powers.*;

public class SuperViewHero<T extends XRayVision>  //可以给他看的超能力
extends SuperHero<T> {
    public SuperViewHero(T power) {
        super(power);
    }

    public void superSee(){
        power.seeThroughWall();
    }
}
