package Design_Patterns2.GiveToSubClass.Factory_Method.framework;

public abstract class Factory {

    //�����õ���ģ�巽��ģʽ������������������ģ�巽��������ʵ��
    public Product create(String owner){
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    public abstract Product createProduct(String owner);//������������˹�������
    public abstract void registerProduct(Product product);

}
