package Design_Patterns2.consider_separately.StrategyPattern;

class Player {
    private String name;
    private Strategy strategy;
    private int winCount;
    private int loseCount;
    private int gameCount;

    Player(String name,Strategy strategy){
        this.name = name;
        this.strategy = strategy;
    }

    Hand nextHand(){
        return strategy.nextHand();
    }

    void win(){
        strategy.study(true);
        winCount++;
        gameCount++;
    }

    void lose(){
        strategy.study(false);
        loseCount++;
        gameCount++;
    }

    void even(){
        gameCount++;
    }

    @Override
    public String toString() {
        return "[" + name + ":" + gameCount + " games, " + winCount + " win, " + loseCount + " lose]";
    }
}
