package Design_Patterns2.generate_instance.Prototype;

import Design_Patterns2.generate_instance.Prototype.framework.*;

public class UnderlinePen implements Product {
    private char underlineChar;
    private String label;
    private int[] arrayInPen;

    public UnderlinePen(char underlineChar){
        this.underlineChar = underlineChar;
        label = "proto pen";
        arrayInPen = new int[]{1,2,3};
    }

    @Override
    public void work(String mainString) {
        int length = mainString.length();
        System.out.println("\"" + mainString + "\"");
        for (int i = 0;i<length + 2;i++){
            System.out.print(underlineChar);
        }
        System.out.println();
    }

    @Override
    public Product createClone() {
        Product p = null;
        try {
            p = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public void printA1() {
        System.out.println(arrayInPen[0]);
    }
}
