package Design_Patterns2.GiveToSubClass.Factory_Method.cake;


import Design_Patterns2.GiveToSubClass.Factory_Method.framework.*;
public class Cake extends Product{

    private String protagonistName;//主人公名字

    Cake(String protagonistName){
        System.out.println("make " + protagonistName + "'s cake");
        this.protagonistName = protagonistName;
    }

    @Override
    public void use() {
        System.out.println(protagonistName + " eat his cake");
    }

    String getProtagonistName(){
        return protagonistName;
    }
}
