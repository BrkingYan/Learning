package Design_Patterns.NO4_Factory_Mode;

public class Hamburger_clam extends Hamburger {
    @Override
    public double cost() {
        return 10;
    }

    @Override
    public void fire() {
        this.state += " fired";
    }

    @Override
    public void hot() {
        this.state += " hot";
    }

    @Override
    public void ice() {
        this.state += " iced";
    }

    @Override
    public void setType() {
        this.state += " clam hamburger";
    }


}
