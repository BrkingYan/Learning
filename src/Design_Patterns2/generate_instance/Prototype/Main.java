package Design_Patterns2.generate_instance.Prototype;

import Design_Patterns2.generate_instance.Prototype.framework.ProductManager;
import Design_Patterns2.generate_instance.Prototype.framework.Product;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        //����ԭ����
        UnderlinePen pen = new UnderlinePen('-');
        Product box = new MessageBox('*');
        pen.work("hello world");
        //ע��ԭ����
        manager.registerProduct("first product",pen);
        manager.registerProduct("second product",box);
        //��¡ԭ����
        Product clonedPen = manager.createCloneProduct("first product");
        Product clonedBox = manager.createCloneProduct("second product");
        clonedPen.work("hello world");
        clonedBox.work("hello world");

        //�鿴ԭ�������¡�����Ƿ���ͬһ��
        System.out.println((pen == clonedPen));

        //�鿴ԭ�������¡�����label�Ƿ���ͬ
        System.out.println("proto pen's label : " + pen.getLabel());
        System.out.println("clone pen's label : " + clonedPen.getLabel());
        //�鿴ԭ�������¡����������Ƿ���ͬ
        System.out.print("proto pen's a1 : ");
        pen.printA1();
        System.out.print("clone pen's a1 : ");
        clonedPen.printA1();
        //�޸Ŀ�¡����
        clonedPen.setLabel("cloned pen");//�޸Ŀ�¡���󲢲���Ӱ��ԭ����
        System.out.println("#############after change#############");
        System.out.println("proto pen's label : " + pen.getLabel());
        System.out.println("clone pen's label : " + clonedPen.getLabel());

    

    }
}
