package Design_Patterns.NO4_Factory_Mode;

public class Pizza_cheese extends Pizza {

    private double price = 9;

    Pizza_cheese(PriceData pd) {
        this.priceData = pd;
        priceData.register(this);
    }

    Pizza_cheese(){

    }

    @Override
    public void bake() {
        this.state = state + " baked";
    }

    @Override
    public void cut() {
        this.state = state + " cut";
    }

    @Override
    public void box() {
        this.state = state + " boxed";
    }

    @Override
    public void setType() {
        this.state += " cheese pizza";
    }

    @Override
    public double cost() {
        return price;
    }



    @Override
    public void update(double disCount) {
        this.price -= disCount;
        this.state += " (discounted)";
    }
}
