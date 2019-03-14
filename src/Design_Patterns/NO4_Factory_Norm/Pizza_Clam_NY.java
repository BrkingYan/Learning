package Design_Patterns.NO4_Factory_Norm;

 class Pizza_Clam_NY extends Pizza {

    public Pizza_Clam_NY() {
        name = "NY style clam pizza";
        toppingList.add("NY salt");
        toppingList.add("NY sauce");
    }

    @Override
    public void bake() {
        System.out.println("bake for 15min(NY time)");
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
