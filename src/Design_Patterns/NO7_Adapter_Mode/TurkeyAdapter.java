package Design_Patterns.NO7_Adapter_Mode;

 class TurkeyAdapter implements Duck {
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey){
        this.turkey = turkey;
    }
    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for (int i = 0;i<5;i++){//火鸡飞得不远，因此得多飞几段才能让行为看起来像鸭子
            turkey.fly();
        }
    }
}
