package ThinkingInJava.generics.Border;

class FruitPlate<T extends Fruit> {
    private T fruit;

    FruitPlate(T fruit){
        this.fruit = fruit;
    }

    void showFruit(){
        fruit.fruit();
    }
}
