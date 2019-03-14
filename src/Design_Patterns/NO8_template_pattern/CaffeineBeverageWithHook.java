package Design_Patterns.NO8_template_pattern;

abstract class CaffeineBeverageWithHook {
    void prepareRecipe(){
        boilWater();
        brew();
        pourIntoCup();
        if (customerWantsCondiments()){ //当顾客想要调料时，才加入调料
            addCondiments();
        }
    }
    /*
     * 由于咖啡和茶的浸泡方式和加入的调料不同，因此这两个方法是抽象的，具体实现放在咖啡和茶本身中实现
     * */
    abstract void brew();
    abstract void addCondiments();

    void boilWater(){
        System.out.println("Boiling water");
    }
    void pourIntoCup(){
        System.out.println("pouring into cup");
    }
    boolean customerWantsCondiments(){  //这就是一个钩子，子类可以覆盖这个方法，但是不见得一定要这么做
        return true;
    }
}
