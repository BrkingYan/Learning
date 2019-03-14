package Design_Patterns.NO9_Iterator_Mode;

import java.util.ArrayList;
import java.util.Iterator;

public class PancakeHouseMenuIterator implements Iterator {

    ArrayList items;
    int position;

    public PancakeHouseMenuIterator(ArrayList items){
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        if (position >= items.size() || items.get(position) == null)
            return false;
        else
            return true;
    }

    @Override
    public Object next() {
        MenuItem menuItem = (MenuItem) items.get(position);
        position ++;
        return menuItem;
    }


}
