package ThinkingInJava.generics.Simple;

class FruitGenerator implements Generator<Fruit> {
    @Override
    public Fruit newElement() {
        return new Fruit();
    }
}
