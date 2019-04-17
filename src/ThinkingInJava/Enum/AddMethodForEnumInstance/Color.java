package ThinkingInJava.Enum.AddMethodForEnumInstance;

enum  Color {
    RED{
        @Override
        void show() {
            System.out.println("red color");
        }

        @Override
        void solidShow() {
            System.out.println("red solid show");
        }
    },
    GREEN {
        @Override
        void show() {
            System.out.println("green color");
        }

        @Override
        void solidShow() {
            System.out.println("green solid show");
        }
    };

    abstract void show();
    void solidShow(){
        System.out.println("Color");
    }
}
