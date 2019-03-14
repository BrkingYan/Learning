package Design_Patterns.NO4_Factory_Norm;

 class Pizza_Clam_Chicago extends Pizza {
    public Pizza_Clam_Chicago() {
        name = "Chicago style clam pizza";
        toppingList.add("Chicago salt");
        toppingList.add("Chicago sauce");
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
