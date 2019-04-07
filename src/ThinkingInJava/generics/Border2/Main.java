package ThinkingInJava.generics.Border2;

import ThinkingInJava.generics.Border2.Heros.*;
import ThinkingInJava.generics.Border2.Powers.SuperHearSmell;
import ThinkingInJava.generics.Border2.Powers.SuperVision;

public class Main {
    public static void main(String[] args) {
        DogBoy boy = new DogBoy();
        boy.superHear();
        boy.superSmell();
        System.out.println("-------------------------");

        SuperViewHero viewHero = new SuperViewHero<>(new SuperVision());
        viewHero.superSee();
        System.out.println("-------------------------");

        SuperHearAndSmellHero hearAndSmellHero = new SuperHearAndSmellHero<>(new SuperHearSmell());
        hearAndSmellHero.superHear();
        hearAndSmellHero.superSmell();


    }
}
