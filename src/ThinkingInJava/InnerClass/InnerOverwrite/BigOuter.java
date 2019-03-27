package ThinkingInJava.InnerClass.InnerOverwrite;

class BigOuter {
    private String name = "123";
    private static String staticName = "321";
    class Inner{
        //普通内部类和匿名内部类都能访问外围类的成员
        void show(){
            System.out.println("BigOuter.Inner.show()" + name);
            new Person(){
              String newName = name + "f";
              void show(){
                  show(newName);
              }
            }.show();
        }
    }

    static class StaticInner{
        void show(){
            System.out.println("BigOuter.StaticInner.show()" + staticName );
        }
    }

    BigOuter getObject(){
        return new BigOuter();
    }
}
