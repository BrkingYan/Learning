package Design_Patterns2.generate_instance.Prototype;

import Design_Patterns2.generate_instance.Prototype.framework.ProductManager;
import Design_Patterns2.generate_instance.Prototype.framework.Product;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        //产生原对象
        UnderlinePen pen = new UnderlinePen('-');
        Product box = new MessageBox('*');
        pen.work("hello world");
        //注册原对象
        manager.registerProduct("first product",pen);
        manager.registerProduct("second product",box);
        //克隆原对象
        Product clonedPen = manager.createCloneProduct("first product");
        Product clonedBox = manager.createCloneProduct("second product");
        clonedPen.work("hello world");
        clonedBox.work("hello world");

        //查看原对象与克隆对象是否是同一个
        System.out.println((pen == clonedPen));

        //查看原对象与克隆对象的label是否相同
        System.out.println("proto pen's label : " + pen.getLabel());
        System.out.println("clone pen's label : " + clonedPen.getLabel());
        //查看原对象与克隆对象的数组是否相同
        System.out.print("proto pen's a1 : ");
        pen.printA1();
        System.out.print("clone pen's a1 : ");
        clonedPen.printA1();
        //修改克隆对象
        clonedPen.setLabel("cloned pen");//修改克隆对象并不会影响原对象
        System.out.println("#############after change#############");
        System.out.println("proto pen's label : " + pen.getLabel());
        System.out.println("clone pen's label : " + clonedPen.getLabel());

    

    }
}
