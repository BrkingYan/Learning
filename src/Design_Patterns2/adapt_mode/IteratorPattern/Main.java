package Design_Patterns2.adapt_mode.IteratorPattern;

import com.sun.jmx.snmp.internal.SnmpSubSystem;

public class Main {
    public static void main(String[] args){
        BookShelf bookShelf = new BookShelf();
        bookShelf.appendBook(new Book("first book"));
        bookShelf.appendBook(new Book("second book"));
        bookShelf.appendBook(new Book("third book"));
        bookShelf.appendBook(new Book("fourth book"));

        BookShelfIterator it = new BookShelfIterator(bookShelf);
        while (it.hasNext()){
            Book book = (Book) it.next();
            System.out.println(book.getName());
        }

        System.out.println("#####################################");

        DinnerTable dinnerTable = new DinnerTable();
        dinnerTable.addDinner(new Dinner("first dinner",23));
        dinnerTable.addDinner(new Dinner("second dinner",12));
        dinnerTable.addDinner(new Dinner("third dinner",21));
        dinnerTable.addDinner(new Dinner("forth dinner",34));
        dinnerTable.addDinner(new Dinner("5th dinner",11));
        dinnerTable.addDinner(new Dinner("6th dinner",24));

        DinnerTableIterator it2 = new DinnerTableIterator(dinnerTable);
        while (it2.hasNext()){
            Dinner dinner = (Dinner) it2.next();
            System.out.println(dinner.getName() + "   " + dinner.getPrice());
        }
    }
}
