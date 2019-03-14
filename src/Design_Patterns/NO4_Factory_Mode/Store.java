package Design_Patterns.NO4_Factory_Mode;

public abstract class Store {
    String brand = null;
    //public abstract void makeBrand(String newBrand);

    public void makeBrand(String newBrand){
        this.brand = newBrand;
    }

}
