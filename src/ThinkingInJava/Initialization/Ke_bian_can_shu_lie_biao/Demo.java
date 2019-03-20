package ThinkingInJava.Initialization.Ke_bian_can_shu_lie_biao;


/*
*  在 Java 5 中提供了变长参数，允许在调用方法时传入不定长度的参数。变长参数是 Java 的一个语法糖，本质上还是基于数组的实现：
*  一个方法只能有一个可变长参数，并且这个可变长参数必须是该方法的最后一个参数
*
* public void foo(String...varargs){}
* foo("arg1", "arg2", "arg3");
* //上述过程和下面的调用是等价的
* foo(new String[]{"arg1", "arg2", "arg3"});
*
* */
public class Demo {
    static void functionString(int num,String... elements){
        System.out.print("num : " + num + " ");
        for (String s : elements){
            System.out.print(s + " ");
        }
        System.out.println();
    }

    static void functionInteger(int num,Integer... elements){
        System.out.print("num : " + num + " ");
        for (int s : elements){
            System.out.print(s + " ");
        }
        System.out.println();
    }

    static void functionPerson(int num,Person... elements){
        System.out.print("num : " + num + " ");
        for (Person s : elements){
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        functionString(1,"one");
        functionString(2,"one",new String("123"));
        functionString(0);
        System.out.println("********************************");
        functionInteger(1,12);
        functionInteger(2,12,new Integer(45));
        functionInteger(0);
        System.out.println("********************************");
        functionPerson(1,new Person("zhangsan",21));
        functionPerson(2,new Person("zhangsan",21),new Person("lisi",18));
        functionPerson(0);
    }
}
