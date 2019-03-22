package Design_Patterns2.GiveToSubClass.Template_Method;

class CharDisplay extends AbstractDisplay {

    char ch;
    public CharDisplay(char ch){
        this.ch = ch;
    }

    @Override
    protected void open() {
        System.out.print("<<");
    }

    @Override
    protected void print() {
        System.out.print(ch);
    }

    @Override
    void close() {
        System.out.println(">>");
    }

    
}
