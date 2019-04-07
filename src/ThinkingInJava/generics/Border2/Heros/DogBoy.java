package ThinkingInJava.generics.Border2.Heros;

import ThinkingInJava.generics.Border2.Powers.*;

public class DogBoy extends SuperHearAndSmellHero<SuperHearSmell> {
    public DogBoy() {
        super(new SuperHearSmell());
    }
}
