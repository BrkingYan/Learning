package Design_Patterns.NO2_ObserverMode2;

 class Person {
    private String name;
    private int age;

    Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public void addName(String addStr){
        name = addStr;
    }

    public void addAge(int addAg){
        age = age + addAg;
    }
}
