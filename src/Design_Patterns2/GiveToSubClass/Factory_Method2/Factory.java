package Design_Patterns2.GiveToSubClass.Factory_Method2;

import java.util.List;

abstract class Factory {
    //这里用到了模板方法模式，工厂方法就是利用模板方法来创建实例
    public Product create(String owner){
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    public abstract Product createProduct(String owner);//这个方法体现了工厂方法
    public abstract void registerProduct(Product product);
    public abstract List getOwners();
}
