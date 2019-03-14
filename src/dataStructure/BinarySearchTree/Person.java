package dataStructure.BinarySearchTree;



/*
 *  Comparable 位于 java.lang 包下
 *  Comparable接口强制进行自然排序
 * */
class Person implements Comparable<Person>{
    private String name;
    private int age;
    private int salary;

    public Person(String name,int age,int salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }




    @Override
    public String toString() {
        return "Person " + this.name + "age : " + this.age + "  salary : " + this.salary;
    }

    @Override
    public int compareTo(Person o) {
        if (this.age > o.age){
            return 1;
        }else if (this.age < o.age){
            return -1;
        }else if (this.age == o.age){
            if (this.salary > o.salary){
                return 1;
            }else if (this.salary < o.salary){
                return -1;
            }
        }
        return 0;
    }

}

