package Design_Patterns.NO4_Factory_Mode;

import java.util.ArrayList;

public class PriceData implements Subject {

    double disCount;
    private ArrayList observers;


    public PriceData(){
         observers = new ArrayList<Observer>();
    }

    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void remove(Observer o) {
        int index = observers.indexOf(o);
        observers.remove(index);
    }

    @Override
    public void notifyObserver() {
        for(int i = 0 ; i<observers.size();i++){
            Observer observer = (Observer) observers.get(i);
            observer.update(disCount);
        }
    }

   public void setDisCount(double disCount){
        this.disCount = disCount;
        priceChanged();
   }

   public void priceChanged(){
        notifyObserver();
   }
}
