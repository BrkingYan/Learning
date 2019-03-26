package Design_Patterns2.consider_separately.StrategyPattern;

import java.util.Random;

public class ProbStrategy implements Strategy {

    private Random random;
    private int prePrevHandValue = 0;
    private int prevHandValue = 0;
    // playHistory[a][b] 表示 在前一次出a的情况下，再出b，胜利的次数
    private int[][] playHistory = {
            {1,1,1},
            {1,1,1},
            {1,1,1}
    };

    ProbStrategy(int seed){
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        int bet = random.nextInt(getSum(prevHandValue));
        int handValue;
        if (bet < playHistory[prevHandValue][0])
            handValue = 0;
        else if (bet < playHistory[prevHandValue][0] + playHistory[prevHandValue][1])
            handValue = 1;
        else
            handValue = 2;
        prePrevHandValue = prevHandValue;
        prevHandValue = handValue;
        return Hand.getHand(handValue);
    }

    //前一次的出手为prevValue的前提下，第二次出各种值的次数之和
    private int getSum(int prevValue){
        int sum = 0;
        for(int i = 0;i < 3;i ++){
            sum += playHistory[prevValue][i];
        }
        return sum;
    }


    @Override
    public void study(boolean win) {
        /*
        * 如果这次赢了
        * */
        if (win)
            playHistory[prePrevHandValue][prevHandValue]++;
        else
            playHistory[prePrevHandValue][(prevHandValue + 1) % 3]++;
            playHistory[prePrevHandValue][(prevHandValue + 2) % 3]++;
    }
}
