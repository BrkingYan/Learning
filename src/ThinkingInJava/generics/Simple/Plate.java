package ThinkingInJava.generics.Simple;

import java.util.ArrayList;
import java.util.List;

class Plate<T> {
    T food;

    Plate(T food){
        this.food = food;
    }


    T getFood(){
        return food;
    }
    void setFood(T food){
        this.food = food;
    }
    void showFoodType(){
        System.out.println(food.getClass().getSimpleName());
    }
}
