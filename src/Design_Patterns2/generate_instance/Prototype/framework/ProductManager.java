package Design_Patterns2.generate_instance.Prototype.framework;

import java.util.HashMap;

public class ProductManager {
    private HashMap<String, Product> productRegister;

    public ProductManager(){
        productRegister = new HashMap<>();
    }

    public void registerProduct(String productName, Product protoProduct){
        productRegister.put(productName,protoProduct);
    }

    //ͨ����������ԭ��Ʒ����ʵ��
    public Product createCloneProduct(String protoProductName){
        Product protoProduct =  productRegister.get(protoProductName);
        return protoProduct.createClone();//����ԭʵ����һ������
    }
}
