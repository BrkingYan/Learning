package Design_Patterns2.consider_separately.StrategyPattern;

class Hand {
    private static final int HANDVALUE_STONE = 0;
    private static final int HANDVALUE_SCISSORS = 1;
    private static final int HANDVALUE_CLOTH = 2;
    private int handValue;

    private Hand(int handValue){
        this.handValue = handValue;
    }

    private static final Hand[] hands = {
            new Hand(HANDVALUE_STONE),
            new Hand(HANDVALUE_SCISSORS),
            new Hand(HANDVALUE_CLOTH)
    };

    private static final String[] handNames = {
            "石头","剪刀","布"
    };
    //单例模式
    static Hand getHand(int handValue){
        return hands[handValue];
    }

    boolean isStrongerThan(Hand anotherHand){
        return compareResult(anotherHand) == 1;
    }

    boolean isWeakerThan(Hand anotherHand){
        return compareResult(anotherHand) == -1;
    }


    private int compareResult(Hand anotherHand){
        if (this == anotherHand)
            return 0;
        else if ((this.handValue + 1) % 3 == anotherHand.handValue)
            return 1;
        else
            return -1;
    }
}
