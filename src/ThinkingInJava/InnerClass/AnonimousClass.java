package ThinkingInJava.InnerClass;

public class AnonimousClass {

    //匿名内部类继承一个类
    private Person x = new Person("jack",21){
        //匿名内部类作为成员
        int id = 99;
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
    };
    //匿名内部类实现一个接口
    private MyInterface m = new MyInterface() {
        @Override
        public void show() {
            System.out.println("interface's son");
        }
    };

    private Person setPersonId(String ss){
        String sss = "ggg";
        //sss = "123";//只要sss不动，就能用，否则就需要声明为final
        return new Person("john",33){
            @Override
            int getId() {
                return 0;
            }
            private String id = sss;
            public String readId(){
                return id;
            }
        };
    }

    private Person getPerson(){
        return x;
    }

    private Person setPerson(Person x){
        x.setAge(99);
        return x;
    }



    private void printNameAndAge(){
        System.out.println("printNameAndAge&&&");
        System.out.println("name : " + x.getName() + "  age : " + x.getAge() + " id : " + x.getId());
    }

    private void printId(){
        //匿名内部类在方法中
        int id = new Person("jack",21){
            int id = 9;
            public int getId() {
                return id;
            }
            public void setId(int id) {
                this.id = id;
            }
        }.getId();
        System.out.println(id);
    }



    public static void main(String[] args) {
        AnonimousClass a = new AnonimousClass();
        a.printNameAndAge();
        a.printId();

        Person p = a.setPerson(a.getPerson());
        System.out.println("name : " + p.getName() + "  age : " + p.getAge());

        Destination d = a.destination("222");
        a.m.show();
        System.out.println("ni ming class's name:" + a.x.getClass().getSimpleName());
    }

    /*
    * 值得注意的是，从JDK1.8开始，编译器不要求自由变量一定要声明为final，
    * 如果这个变量在后面的使用中没有发生变化，就可以通过编译，Java称这种情况为“effectively final”。
    * */
    Destination destination(String dest){
        //! dest = "wuhan";//只要dest不动，就能用，否则就需要声明为final
        return new Destination(){
            private String label = dest;//effectly final : 系统默认添加final
            public String readLabel(){
                label = "aa";
                return label;
            }
        };
    }
    private Person createPerson(String name,int age){
        name += "sd";
        age += 12;
        return new Person(name,age){ //直接传给构造器没事，
            // String desc = name;//但是要在内部类内部使用局部变量就不行了
            @Override
            int getId() {
                return 0;
            }
        };
    }

    Destination destination2(){
        String dest = "wuhan";
        //! dest += "1"; //只要dest不动，就能用，否则就需要声明为final
        return new Destination(){
            private String label = dest;
            public String readLabel(){
                label = "aa";
                return label;
            }
        };
    }

}
