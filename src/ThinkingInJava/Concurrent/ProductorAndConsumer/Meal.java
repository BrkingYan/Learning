package ThinkingInJava.Concurrent.ProductorAndConsumer;

class Meal {
    private final int orderNum;
    Meal(int orderNum){
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal " + orderNum;
    }
}
