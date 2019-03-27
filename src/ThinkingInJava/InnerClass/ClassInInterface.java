package ThinkingInJava.InnerClass;

interface ClassInInterface {
    //public static 都是多余的
    public static class SubClass implements ClassInInterface{

        @Override
        public void show() {
            System.out.println("subClass's name : " + this.getClass().getName());//ClassInInterface$SubClass
        }

        //嵌套类中的Main方法
        public static void main(String[] args) {
            new ClassInInterface.SubClass().show();
        }
    }

    public static void main(String[] args) {
        new SubClass().show();
    }

    void show();
}
