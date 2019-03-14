package Design_Patterns.NO9_Iterator_Mode;

import java.util.Iterator;

public class DinnerMenuIterator implements Iterator {

    MenuItem[] items;
    int position;

    public DinnerMenuIterator(MenuItem[] items){
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        if (position >= items.length || items[position] == null)
        return false;
        else
            return true;
    }

    @Override
    public Object next() {
        MenuItem menuItem = items[position];
        position ++;
        return menuItem;
    }
}
