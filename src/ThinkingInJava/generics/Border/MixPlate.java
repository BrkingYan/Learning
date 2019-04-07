package ThinkingInJava.generics.Border;

class MixPlate<T extends Fruit & Meal> {  //ֻ��һ����Ͷ���ӿ�
    // T ����̳�Fruit ��ʵ��Meal�ӿ�

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
