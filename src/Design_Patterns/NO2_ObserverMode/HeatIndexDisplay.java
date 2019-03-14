package Design_Patterns.NO2_ObserverMode;

 class HeatIndexDisplay implements Observer,DisplayElement {


    private float temparature;
    private float humidity;
    private float heatIndex;
    private Subject weatherData;

    public HeatIndexDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }


    @Override
    public void display() {
        System.out.println("the heatindex is "+ heatIndex);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temparature = temp;
        this.humidity = humidity;
        heatIndex = temp + humidity;
        display();
    }
}
