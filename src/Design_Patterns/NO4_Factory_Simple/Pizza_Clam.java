package Design_Patterns.NO4_Factory_Simple;

class Pizza_Clam extends Pizza {


     public Pizza_Clam() {
         name = "Clam Pizza";
         toppingList.add("sauce");
         toppingList.add("salt");
         toppingList.add("jam");
     }

     @Override
    public void bake() {
        System.out.println("bake for 20min");
    }

    @Override
    public void cut() {
        System.out.println("cut with a big knife");
    }

    @Override
    public void box() {
        System.out.println("box in a gray box : "+name);
    }
}
