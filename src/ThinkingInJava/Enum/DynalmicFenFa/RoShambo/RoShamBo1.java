package ThinkingInJava.Enum.DynalmicFenFa.RoShambo;

import java.util.Random;

public class RoShamBo1 {
    static final int SIZE = 20;


    public static void match(Item a, Item b) {
        System.out.println(a + " vs. " + b + ": " + a.compete(b));
    }

    public static void main(String[] args) {
        Paper paper = new Paper();
        Rock rock = new Rock();
        match(paper,rock);
    }
}
