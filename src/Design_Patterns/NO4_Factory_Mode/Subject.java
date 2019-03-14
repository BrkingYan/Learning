package Design_Patterns.NO4_Factory_Mode;

public interface Subject {
    public void register(Observer o);
    public void remove(Observer o);
    public void notifyObserver();
}
