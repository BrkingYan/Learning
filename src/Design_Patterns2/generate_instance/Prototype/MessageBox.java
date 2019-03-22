package Design_Patterns2.generate_instance.Prototype;

import Design_Patterns2.generate_instance.Prototype.framework.*;

public class MessageBox implements Product {
    private char boxChar;
    private String label;


    public MessageBox(char boxChar){
        this.boxChar = boxChar;
        label = "proto box";
    }

    @Override
    public void work(String mainString) {
        int length = mainString.length();
        for (int i = 0;i < length + 4;i++){
            System.out.print(boxChar);
        }
        System.out.println();
        System.out.println(boxChar + " " + mainString + " " + boxChar);
        for (int i = 0;i < length + 4;i++){
            System.out.print(boxChar);
        }
        System.out.println();
    }

    @Override
    public Product createClone() {
        Product p = null;
        try {
            p = (Product)clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public void printA1() {

    }
}
