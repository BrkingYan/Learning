package ThinkingInJava.generics.Border2.Heros;

import ThinkingInJava.generics.Border2.Powers.*;

public class SuperHearAndSmellHero<T extends  SuperHearing & SuperSmell>//可以给他听和闻的超能力
extends SuperHero<T>{
    public SuperHearAndSmellHero(T power) {
        super(power);
    }

    public void superHear(){
        power.hearSubtleNoises();
    }

    public void superSmell(){
        power.smellDistance();
    }
}
