package ThinkingInJava.Reflect.DynamicProxy.MyCompany;

class Person {
    private String name;
    private String age;
    static final Person NULLPERSON = new NullPerson();

    Person(String name,String age){
        this.name = name;
        this.age = age;
    }

    static class NullPerson extends Person implements Null{
        private NullPerson(){
            super("null","null");
        }

        @Override
        public String toString() {
            return "NullPerson";
        }
    }

    @Override
    public String toString() {
        return "Person: " + name + " age: " + age;
    }
}
