package Design_Patterns2.GiveToSubClass.Factory_Method.idcard;

import Design_Patterns2.GiveToSubClass.Factory_Method.framework.*;

import java.util.ArrayList;
import java.util.List;

public class IdCardFactory extends Factory {

    private List<String> owners;

    public IdCardFactory(){
        System.out.println("id card factory run");
        owners = new ArrayList<>();
    }

    //这个地方体现了工厂方法
    @Override
    public Product createProduct(String owner) {
        return new IdCard(owner);
    }

    @Override
    public void registerProduct(Product product) {
        owners.add(((IdCard)product).getOwnerName());
    }

    public List getOwners(){
        return owners;
    }
}
