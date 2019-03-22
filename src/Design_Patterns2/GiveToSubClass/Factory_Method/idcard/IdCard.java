package Design_Patterns2.GiveToSubClass.Factory_Method.idcard;


import Design_Patterns2.GiveToSubClass.Factory_Method.framework.*;

public class IdCard extends Product {

    private String ownerName;

    IdCard(String owner){
        System.out.println("create " + owner + "'s id card");
        this.ownerName = owner;
    }

    @Override
    public void use() {
        System.out.println(ownerName + " used his id card");
    }

    String getOwnerName(){
        return ownerName;
    }
}
