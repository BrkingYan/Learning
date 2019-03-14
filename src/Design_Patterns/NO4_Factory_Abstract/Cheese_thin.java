package Design_Patterns.NO4_Factory_Abstract;

public class Cheese_thin implements Cheese {
    @Override
    public String getType() {
        return "additional ingredient with : thin cheese";
    }
}
