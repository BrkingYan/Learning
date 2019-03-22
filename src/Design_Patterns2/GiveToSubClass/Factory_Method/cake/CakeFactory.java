package Design_Patterns2.GiveToSubClass.Factory_Method.cake;

import Design_Patterns2.GiveToSubClass.Factory_Method.framework.*;

import java.util.ArrayList;
import java.util.List;

public class CakeFactory extends Factory {

    private List<String> Protagonists;

    public CakeFactory(){
        System.out.println("cake factory run");
        Protagonists = new ArrayList<>();
    }

    @Override
    public Product createProduct(String owner) {
        return new Cake(owner);
    }

    @Override
    public void registerProduct(Product product) {
        Protagonists.add(((Cake)product).getProtagonistName());
    }

    public List<String> getProtagonists(){
        return Protagonists;
    }
}
