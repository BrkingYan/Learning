package Design_Patterns2.adapt_mode.IteratorPattern;

class Dinner{
    private String name;
    private int price;


    public Dinner(String name,int price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }


}
