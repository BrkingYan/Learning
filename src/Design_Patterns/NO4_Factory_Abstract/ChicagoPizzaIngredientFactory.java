package Design_Patterns.NO4_Factory_Abstract;

public class ChicagoPizzaIngredientFactory implements PizzaIngerdientFactory {


    @Override
    public Sauce createSauce(String type) {
        if (type == "black"){
            return new Sauce_black();
        }
        else if (type == "white"){
            return new Sauce_white();
        }
        else if (type == "no sauce"){
            return null;
        }
        else
            throw new NullPointerException("no such sauce in Chicago Ingredient factory");
    }

    @Override
    public Clam createClam(String type) {
        if (type == "fresh"){
            return new Clam_fresh();
        }
        else if (type == "froze"){
            return new Clam_froze();
        }
        else
            throw new NullPointerException("no such Clam in Chicago Ingredient factory");
    }

    @Override
    public Cheese createCheese(String type) {
        if (type == "thick"){
            return new Cheese_thick();
        }
        else if (type == "thin"){
            return new Cheese_thin();
        }
        else
            throw new NullPointerException("no such Cheese in Chicago Ingredient factory");
    }
}
