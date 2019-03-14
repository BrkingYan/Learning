package tempTestBed;


public class StaticInit {

    static void printArray(Object... arg){

/*        for (Object obj:arg){
            System.out.print(obj+" ");
        }
        System.out.println();
*/
    }

    static void printArray1(Object[] arg){
        for (Object obj:arg){
            System.out.print(obj+" ");
        }
        System.out.println();
    }


    public static void main(String[] args){
        printArray(1,2,3);
        printArray("1",2,'a');
        printArray(new Float(2.0f),new Integer(3),new String());
        printArray(new Integer[]{3,4,5,});
        printIntArray(1,2,3);
        printIntArray(new Integer(1),new Integer(2),new Integer(3));

        System.out.println("####################################################");

        printArray1(new Object[]{"1","2",new Float(5),new Integer(45)});
        printArray1((Object[]) new Integer[]{1,2,3,4,5});
        //printArray1({1,2,4,5,6});

        System.out.println("#####################################################");
        printArray(new Integer[]{3,2,1},1,2);

        System.out.println("######################################################");
        f('a','b');
        g(5,new Integer(2),new Integer(3));

        f1('a');
        f1('b','a');
        f1(1,'a','c');

        System.out.println("#######################################################");
        Spiciness medium = Spiciness.MEDIUM;
        System.out.println(Spiciness.values());
        for (Spiciness s:Spiciness.values()){
            System.out.println(s+"  ordinal is : "+s.ordinal());
        }
        System.out.println(medium.ordinal());

    }

    static void printIntArray(Integer... arg){
        for (Integer integer:arg){
            System.out.print(integer+" ");
        }
        System.out.println();
    }


    static void f(Character... args){
        System.out.println(args.getClass().getName());
        System.out.println(args.length);
    }

    static void g(Integer... args){
        System.out.println(args.getClass().getName());
        System.out.println(args.length);
    }

    static void f1(char i,Character... args){
        System.out.println("first");
    }

    static void f1(int i ,Character... args){
        System.out.println("second");
    }
}

