package ThinkingInJava.Enum.MultiConstructor;

enum  Color {
    RED("red"),GREEN("green"),BLANK(),YELLOW("yellow"),
    WHITE(){
        @Override
        void show() {
            throw new RuntimeException("white nope");
        }
    },
    NOCOLOR(){
        @Override
        void show() {
            throw new RuntimeException("nocolor nope");
        }
    };

    String color;

    Color(String color){
        this.color = color;
    }

    Color(){

    }

    void show(){
        System.out.println(this.name() + " : " + this.color);
    }


    @Override
    public String toString() {
        return this.name() + " : " + this.color;
    }
}
