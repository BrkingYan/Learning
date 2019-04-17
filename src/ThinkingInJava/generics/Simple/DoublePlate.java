package ThinkingInJava.generics.Simple;

class DoublePlate<K,T> {

    T fruit;
    K meat;

    DoublePlate(T fruit,K meat){
        this.fruit = fruit;
        this.meat = meat;
    }

    T getFruit(){
        return fruit;
    }

    K getMeat(){
        return meat;
    }
}
