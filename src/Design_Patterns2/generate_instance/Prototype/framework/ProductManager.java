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

    //通过复制生产原产品的新实例
    public Product createCloneProduct(String protoProductName){
        Product protoProduct =  productRegister.get(protoProductName);
        return protoProduct.createClone();//返回原实例的一个副本
    }
}
