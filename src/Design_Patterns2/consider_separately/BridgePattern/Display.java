package Design_Patterns2.consider_separately.BridgePattern;

class Display {
    private DisplayImplementor implementor;

    Display(DisplayImplementor implementor){
        this.implementor = implementor;
    }

    void open(){
        implementor.rawOpen();
    }

    void print(){
        implementor.rawPrint();
    }

    void close(){
        implementor.rawClose();
    }

    void display(){
        open();
        print();
        close();
    }
}
