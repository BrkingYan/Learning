package Design_Patterns.Effective_Java.No2.Builder;

public class Person {
    //必要参数
    private int id;
    private String name;
    //可选参数
    private int age;
    private String sex;
    private String phone;
    private String address;
    private String desc;



/*
*  内部类Builder，用于在构造对象时初始化
*  */
/**********************************************/
    public static class Builder {
        private int id;
        private String name;

        private int age;
        private String sex;
        private String phone;
        private String address;
        private String desc;

        public Builder(int id,String name){
            this.id = id;
            this.name = name;
        }

        public Builder age(int age){
            this.age = age;
            return this;
        }

        public Builder sex(String sex){
            this.sex = sex;
            return this;
        }

        public Builder phone(String phone){
            this.phone = phone;
            return this;
        }

        public Builder address(String address){
            this.address = address;
            return this;
        }

        public Builder desc(String desc){
            this.desc = desc;
            return this;
        }

        //内部类的构造器
        public Person build(){
            return new Person(this);
        }
    }
/******************************************************/



    public Person(Builder builder){
        id = builder.id;
        name = builder.name;
        age = builder.age;
        sex = builder.sex;
        phone = builder.phone;
        address = builder.address;
        desc = builder.desc;

    }

    @Override
    public String toString() {
        return "id: " + id + "\nname: " + name + "\nsex: " + sex + "\nphone: " + phone + "\naddress: " + address;
    }
}
