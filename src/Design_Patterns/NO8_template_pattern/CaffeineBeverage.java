package Design_Patterns.NO8_template_pattern;
abstract class CaffeineBeverage {
     final void prepareRecipe(){
         boilWater();
         brew();
         addCondiments();
         pourIntoCup();
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
}
