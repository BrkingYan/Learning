package Design_Patterns2.consider_separately.BridgePattern;

import java.util.Random;

class RandomDisplay extends Display {


    RandomDisplay(DisplayImplementor implementor) {
        super(implementor);
    }

    void randomDisplay(int maxTimes){
        Random rand = new Random();
        int times = (int) (rand.nextFloat() * maxTimes);
        open();
        for (int i = 0;i < times; i++){
            print();
        }
        close();
    }
}
