package Design_Patterns.NO4_Factory_Norm;

class Pizza_Cheese_NY extends Pizza {
    Pizza_Cheese_NY(){
        name = "NY style cheese pizza";
        toppingList.add("NY sugar");
        toppingList.add("NY oil");
    }


    @Override
    public void bake() {
        System.out.println("bake for 10min(NY time)");
    }

    @Override
    public void cut() {
        System.out.println("cut with NY knife");
    }

    @Override
    public void box() {
        System.out.println("box with NY box");
    }
}
