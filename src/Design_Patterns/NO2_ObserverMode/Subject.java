package Design_Patterns.NO2_ObserverMode;

 interface Subject {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}
