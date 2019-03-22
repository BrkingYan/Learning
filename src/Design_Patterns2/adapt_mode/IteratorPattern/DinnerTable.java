package Design_Patterns2.adapt_mode.IteratorPattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class DinnerTable implements Iterable {

    private List<Dinner> dinners;
    private int last;
    private DinnerComparator comparator;

    public DinnerTable(){
        dinners = new ArrayList<>();
        last = 0;
        comparator = new DinnerComparator();
    }

    public void addDinner(Dinner dinner){
        dinners.add(dinner);
        dinners.sort(comparator);
        //Collections.sort(dinners);
        last++;
    }

    public int getLength(){
        return last;
    }

    @Override
    public Iterator iterator() {
        return new DinnerTableIterator(this);
    }

    public Dinner getDinnerAt(int order){
        return dinners.get(order);
    }


}
