package ThinkingInJava.generics.Border2.Heros;

import ThinkingInJava.generics.Border2.Powers.*;

public class SuperHearAndSmellHero<T extends  SuperHearing & SuperSmell>//���Ը��������ŵĳ�����
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
