package ThinkingInJava.generics.Border;

class MixPlate<T extends Fruit & Meal> {  //只能一个类和多个接口
    // T 必须继承Fruit 并实现Meal接口

    T food;
    MixPlate(T food){
        this.food = food;
    }


    void showFruit(){
        food.fruit();
    }

    void showMeal(){
        food.meal();
    }

}
