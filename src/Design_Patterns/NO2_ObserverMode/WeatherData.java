package Design_Patterns.NO2_ObserverMode;

import java.util.ArrayList;
import java.util.List;

class WeatherData implements Subject {
    private float temperature;
    private float humidity;
    private float pressure;
    private ArrayList observers;

    public WeatherData(){
        List<Observer> observers = new ArrayList<Observer>();
    }


    @Override
    public void registerObserver(Observer o) {
            observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if(i>=0){
            observers.remove(o);
        }
    }

    @Override
    public void notifyObservers() {
        for(int i = 0;i<observers.size();i++){
            Observer observer = (Observer) observers.get(i);
            observer.update(temperature,humidity,pressure);
        }
    }

    public void measurementsChanged(){
        notifyObservers();
    }

    public void setMeasurements(float temp,float humidity,float pressure){
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
        WeatherStation.times++;

    }
}
