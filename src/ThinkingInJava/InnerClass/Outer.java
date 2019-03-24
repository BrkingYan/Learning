package ThinkingInJava.InnerClass;


//һ���ڲ���Demo
class Outer {
    private class Inner{
        private String desc;
        private Inner(String innerString){
            desc = innerString;
        }

        public Outer getOuter(){
            return Outer.this;
        }
    }

    private Inner getInner(String desc){
        return new Inner(desc);
    }



    public static void main(String[] args) {
        //��ʽ1
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner("123");
        String desc = inner.desc;
        //��ʽ2
        Outer outer1 = new Outer();
        Outer.Inner inner1 = outer1.getInner("123");

        Outer.Inner inner2 = inner1.getOuter().getInner("123");
    }
}
