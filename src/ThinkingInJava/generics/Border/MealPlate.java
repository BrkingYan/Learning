package ThinkingInJava.generics.Border;

class MealPlate<T extends Meal> {
    T meal;

    MealPlate(T meal){
        this.meal = meal;
    }

    void showMeal(){
        meal.meal();
    }
}
