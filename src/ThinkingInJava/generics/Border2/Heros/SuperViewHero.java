package ThinkingInJava.generics.Border2.Heros;

import ThinkingInJava.generics.Border2.Powers.*;

public class SuperViewHero<T extends XRayVision>  //���Ը������ĳ�����
extends SuperHero<T> {
    public SuperViewHero(T power) {
        super(power);
    }

    public void superSee(){
        power.seeThroughWall();
    }
}
