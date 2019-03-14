package Design_Patterns.NO2_ObserverMode;

import java.util.ArrayList;
import java.util.List;

 class StatisticsDisplay implements Observer,DisplayElement {

    private float temp;
    private float avg = 0;
    private float max = 0;
    private float min = 0;
    //private static int times = 0;
    List<Float> tempList= new ArrayList<Float>();
   //rrayList<> tempList = new float[WeatherData.times +1] ;
    private Subject weatherData;
    private float sum;

    StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);

    }

    @Override
    public void display() {
        System.out.println("Avg/Max/Min temperature = " + avg + "/" + max + "/" + min);
    }


    @Override
    public void update(float temp, float humidity, float pressure) {

        this.temp = temp;
        tempList.add(temp);
        if(WeatherStation.times == 0){
            avg = temp;
            sum = temp;
        }
        else {
            sum = sum + tempList.get(tempList.size()-1);
            //System.out.println(sum);
            avg = sum/(WeatherStation.times+1);

        }
        max = getMax(tempList);
        min = getMin(tempList);
        display();
    }

    public float getMax(List<Float> tempList) {
        float max = tempList.get(0);
        if (WeatherStation.times == 0) {
            return max;
        } else {
            for (int i = 1; i < tempList.size(); i++) {
                if (tempList.get(i) > max)
                    max = tempList.get(i);
            }
            return max;
        }
    }

    public float getMin(List<Float> tempList) {
        float min = tempList.get(0);
        if (WeatherStation.times == 0) {
            return min;
        } else {
            for (int i = 1; i < tempList.size(); i++) {
                if (tempList.get(i) < min)
                    min = tempList.get(i);
            }
            return min;
        }
    }
}
