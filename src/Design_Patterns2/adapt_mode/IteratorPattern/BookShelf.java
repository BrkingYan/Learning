package Design_Patterns2.adapt_mode.IteratorPattern;

import java.util.ArrayList;
import java.util.List;

class BookShelf implements Iterable {
    private List<Book> books;
    private int last;


    public BookShelf(){
        books = new ArrayList<>();
        last = 0;
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }

    public void appendBook(Book book){
        books.add(book);
        last++;
    }

    public Book getBookAt(int index){
        return books.get(index);
    }

    public int getLength(){
        return last;
    }
}
