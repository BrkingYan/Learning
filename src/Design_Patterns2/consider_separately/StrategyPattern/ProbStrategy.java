package Design_Patterns2.consider_separately.StrategyPattern;

import java.util.Random;

public class ProbStrategy implements Strategy {

    private Random random;
    private int prePrevHandValue = 0;
    private int prevHandValue = 0;
    // playHistory[a][b] ��ʾ ��ǰһ�γ�a������£��ٳ�b��ʤ���Ĵ���
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

    //ǰһ�εĳ���ΪprevValue��ǰ���£��ڶ��γ�����ֵ�Ĵ���֮��
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
        * ������Ӯ��
        * */
        if (win)
            playHistory[prePrevHandValue][prevHandValue]++;
        else
            playHistory[prePrevHandValue][(prevHandValue + 1) % 3]++;
            playHistory[prePrevHandValue][(prevHandValue + 2) % 3]++;
    }
}
