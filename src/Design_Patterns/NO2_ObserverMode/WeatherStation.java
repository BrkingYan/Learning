package Design_Patterns.NO2_ObserverMode;

public class WeatherStation {

    public static int times = 0;

    public static void main(String [] args){
        WeatherData weatherData = new WeatherData();

        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

        weatherData.setMeasurements(82,90,35);
        weatherData.setMeasurements(84,70,35);
        weatherData.setMeasurements(80,70,35);
        weatherData.setMeasurements(80,65,33);

        System.out.println();

        //int queue = new ArrayList<Integer>();
    }
}
