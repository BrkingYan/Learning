package ThinkingInJava.generics.Border2.Powers;

public class SuperHearSmell implements SuperHearing,SuperSmell {
    @Override
    public void hearSubtleNoises() {
        System.out.println("hear subtle noises");
    }

    @Override
    public void smellDistance() {
        System.out.println("smell distance");
    }
}
