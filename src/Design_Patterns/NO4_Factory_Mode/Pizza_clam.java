package Design_Patterns.NO4_Factory_Mode;

public class Pizza_clam extends Pizza {
    private double price = 8;

    Pizza_clam(PriceData pd){
        this.priceData = pd;
        priceData.register(this);
    }

    Pizza_clam(){

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
        this.state += " clam pizza";
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
