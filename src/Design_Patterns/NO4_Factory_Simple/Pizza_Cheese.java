package Design_Patterns.NO4_Factory_Simple;

 class Pizza_Cheese extends Pizza {
    Pizza_Cheese(){
        name = "Cheese Pizza";
        toppingList.add("sugar");
        toppingList.add("salt");
        toppingList.add("oil");
    }

    @Override
    public void bake() {
        System.out.println("bake for 10 min");
    }

    @Override
    public void cut() {
        System.out.println("cut with small knife");
    }

    @Override
    public void box() {
        System.out.println("box in a yellow box : "+name);
    }
}
