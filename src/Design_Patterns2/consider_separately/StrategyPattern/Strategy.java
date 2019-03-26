package Design_Patterns2.consider_separately.StrategyPattern;

interface Strategy {
    Hand nextHand();
    void study(boolean win);
}
