package Design_Patterns2.consider_separately.BridgePattern;

class MultiDisplay extends Display {

    MultiDisplay(DisplayImplementor implementor) {
        super(implementor);
    }

    void multiDisplay(int displayTimes){
        open();
        for (int i = 0;i < displayTimes;i ++){
            print();
        }
        close();
    }

}
