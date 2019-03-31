package ThinkingInJava.Exception.GetStackTrace;

public class GetStackTrace {
    public static void main(String[] args) {
        /*a();
        System.out.println("------------------------------------");
        b();
        System.out.println("------------------------------------");*/
        c();
    }

    static void a(){
        try {
            throw new Exception();
        }catch (Exception e){
            for (int i = 0;i < e.getStackTrace().length-1;i++){
                System.out.println(e.getStackTrace()[i].getMethodName() + " is called by " + e.getStackTrace()[i+1].getMethodName());
            }
        }
    }
    /* StackTrace
    * 0   a
    * 1   b
    * 2   c
    * 3   main
    * */

    static void b(){
        a();
    }

    static void c(){
        b();
    }
}
