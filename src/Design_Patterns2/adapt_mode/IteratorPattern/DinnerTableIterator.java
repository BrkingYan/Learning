package Design_Patterns2.adapt_mode.IteratorPattern;

class DinnerTableIterator implements Iterator {

    private DinnerTable dinnerTable;
    private int order;

    public DinnerTableIterator(DinnerTable dinnerTable){
        this.dinnerTable = dinnerTable;
        order = 0;
    }

    @Override
    public boolean hasNext() {
        if (order == dinnerTable.getLength())
            return false;
        return true;
    }

    @Override
    public Object next() {
        Dinner dinner = dinnerTable.getDinnerAt(order);
        order++;
        return dinner;
    }
}
