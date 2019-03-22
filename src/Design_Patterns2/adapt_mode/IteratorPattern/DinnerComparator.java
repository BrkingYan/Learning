package Design_Patterns2.adapt_mode.IteratorPattern;

import java.util.Comparator;

public class DinnerComparator implements Comparator<Dinner> {

    @Override
    public int compare(Dinner o1, Dinner o2) {
        if (o1.getPrice() > o2.getPrice())
            return 1;
        else if (o1.getPrice() < o2.getPrice())
            return -1;
        return 0;
    }
}
