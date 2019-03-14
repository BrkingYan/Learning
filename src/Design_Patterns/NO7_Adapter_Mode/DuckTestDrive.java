package Design_Patterns.NO7_Adapter_Mode;

public class DuckTestDrive {
    public static void main(String[] args){
        System.out.println("....................the turkey says...............................");
        WildTurkey wildTurkey = new WildTurkey();
        wildTurkey.gobble();
        wildTurkey.fly();


        System.out.println(".....................the turkey adapter says...................");
        Duck turkeyAdapter = new TurkeyAdapter(wildTurkey);
        turkeyAdapter.quack();//wildTurkey装进了适配器中，因此它在外界看来就是一只鸭子
        turkeyAdapter.fly();//它用的是鸭子的方法，但是其实真正完成动作还是用的turkey的动作
    }
}
/*
*
* */
