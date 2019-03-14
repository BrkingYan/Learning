package Design_Patterns.NO4_Factory_Mode;

public class Green_Tea extends SupDishes {
    Food foodtea;
    Green_Tea(Food food){
        this.foodtea = food;
        this.state = food.state;
        upToPack();
    }

    private double price = 3;

    @Override
    public double cost() {
        return foodtea.cost() + price;
    }

    @Override
    public void upToPack() {
        this.state += " ...with a Green Tea";
    }


}
