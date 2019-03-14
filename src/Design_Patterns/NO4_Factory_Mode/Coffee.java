package Design_Patterns.NO4_Factory_Mode;

public class Coffee extends SupDishes {
    private double price = 4;
    Food foodcof;

    Coffee(Food food){
        this.foodcof = food;
        this.state = food.state;
        upToPack();
    }

    @Override
    public double cost() {
        return foodcof.cost() + price;
    }

    @Override
    public void upToPack() {
        this.state += "...with a Coffee";
    }
}
