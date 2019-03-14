package Design_Patterns.NO2_ObserverMode;

 class CurrentConditionDisplay implements Observer,DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
        //weatherData.removeObserver(this);
    }
    @Override
    public void display() {
        System.out.println("current condition: "+temperature+"F degrees and"+humidity+"% humidity");
    }
    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }
}
