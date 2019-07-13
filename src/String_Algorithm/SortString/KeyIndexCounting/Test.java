package String_Algorithm.SortString.KeyIndexCounting;

public class Test {
    public static void main(String[] args) {
        Person[] group = new Person[]{new Person("jack",3),
                                      new Person("hohn",2),
                                      new Person("mike",2),
                                      new Person("ghgh",1),
                                      new Person("bobo",3),
                                      new Person("geroge",0),
                                      new Person("gfgg",2)};

        Classifyer classifyer = new Classifyer(group,4);
        Person[] classified = classifyer.classify();
        for (Person p : classified){
            System.out.println(p);
        }
    }
}
