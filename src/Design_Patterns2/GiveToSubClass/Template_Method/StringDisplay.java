package Design_Patterns2.GiveToSubClass.Template_Method;

class StringDisplay extends AbstractDisplay{

    private String string;
    private int stringWidth;

    public StringDisplay(String string){
        this.string = string;
        stringWidth = string.length();
    }

    @Override
    void open() {
        printLine();
    }

    @Override
    void print() {
        System.out.println("|" + string + "|");
    }

    @Override
    void close() {
        printLine();
    }

    private void printLine(){
        System.out.print("+");
        for (int i = 0;i < stringWidth;i++){
            System.out.print("-");
        }
        System.out.println("+");
    }
}
