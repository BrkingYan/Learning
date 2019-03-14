package Design_Patterns.NO2_ObserverMode;

public class ForecastDisplay implements Observer,DisplayElement {

    private float temparature;
    private float humidity;
    private float pressure;
    private Subject weatherData;


     ForecastDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }


    @Override
    public void display() {
        if(temparature>=80){
            System.out.println("hot day , attention !");
        }
        if(humidity>=80){
            System.out.println("attention humidity!");
        }
        if(pressure >= 29.0f){
            System.out.println("high pressure!");
        }
    }


    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temparature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}
