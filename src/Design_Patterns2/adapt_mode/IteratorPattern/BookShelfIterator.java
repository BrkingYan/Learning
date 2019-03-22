package Design_Patterns2.adapt_mode.IteratorPattern;

class BookShelfIterator implements Iterator {

    private BookShelf bookShelf;
    private int index;

    public BookShelfIterator(BookShelf bookShelf){
        this.bookShelf = bookShelf;
        index = 0;
    }
    //ȷ�Ͻ������Ƿ��ܵ���next()����
    @Override
    public boolean hasNext() {
        if (index == bookShelf.getLength())
            return false;
        return true;
    }

    @Override
    public Object next() {
        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
}
