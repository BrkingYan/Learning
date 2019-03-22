package Design_Patterns2.adapt_mode.IteratorPattern;

class BookShelfIterator implements Iterator {

    private BookShelf bookShelf;
    private int index;

    public BookShelfIterator(BookShelf bookShelf){
        this.bookShelf = bookShelf;
        index = 0;
    }
    //确认接下来是否能调用next()方法
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
