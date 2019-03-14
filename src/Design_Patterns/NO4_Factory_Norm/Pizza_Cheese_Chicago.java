package Design_Patterns.NO4_Factory_Norm;

 class Pizza_Cheese_Chicago extends Pizza {

    public Pizza_Cheese_Chicago() {
        name = "Chicago style cheese pizza";
        toppingList.add("Chicago sugar");
        toppingList.add("Chicago oil");
    }

    @Override
    public void bake() {
        System.out.println("bake for 15min(Chicago time)");
    }

    @Override
    public void cut() {
        System.out.println("cut with Chicago knife");
    }

    @Override
    public void box() {
        System.out.println("box with Chicago box");
    }
}
