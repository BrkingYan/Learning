package Design_Patterns2.GiveToSubClass.Factory_Method2;

import java.util.ArrayList;
import java.util.List;

class IdCard extends Product {
    private String ownerName;
    //IdCard唯一的专属工厂 饥饿型
    private static Factory idcardFactory = idcardFactory =
            new Factory() {
                private List<String> owners = new ArrayList<>();;
                @Override
                public Product createProduct(String owner) {
                    return new IdCard(owner);
                }

                @Override
                public void registerProduct(Product product) {
                    owners.add(((IdCard)product).getOwnerName());
                }
                public List getOwners(){
                    return owners;
                }
            };
    private IdCard(String owner){
        this.ownerName = owner;
    }
    @Override
    public void use() {
        System.out.println(ownerName + " used his id card");
    }

    //用匿名内部类给IdCard定制唯一的专属工厂，该工厂的实现细节被IdCard完全封装起来
    //别人无法实例化该工厂的实例对象
    static Factory getIdCardFactory(){
        return idcardFactory;
    }

    /*static void buildFactory(){
        //IdCard唯一的专属工厂
        idcardFactory = new Factory() {
            private List<String> owners = new ArrayList<>();;
            @Override
            public Product createProduct(String owner) {
                return new IdCard(owner);
            }

            @Override
            public void registerProduct(Product product) {
                owners.add(((IdCard)product).getOwnerName());
            }
            public List getOwners(){
                return owners;
            }
        };
    }*/

    String getOwnerName(){
        return ownerName;
    }
}
