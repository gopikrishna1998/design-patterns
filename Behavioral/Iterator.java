import java.util.ArrayList;
import java.util.List;

// Aggregate Interface
interface BookCollection {
    Iterator createIterator();
}

// Concrete Aggregate
class BookList implements BookCollection {
    private List<String> books;

    public BookList() {
        this.books = new ArrayList<>();
    }

    public void addBook(String book) {
        books.add(book);
    }

    @Override
    public Iterator createIterator() {
        return new BookIterator(books);
    }
}

// Iterator Interface
interface Iterator {
    boolean hasNext();
    String next();
}

// Concrete Iterator
class BookIterator implements Iterator {
    private List<String> books;
    private int position = 0;

    public BookIterator(List<String> books) {
        this.books = books;
    }

    @Override
    public boolean hasNext() {
        return position < books.size();
    }

    @Override
    public String next() {
        if (hasNext()) {
            return books.get(position++);
        }
        return null;
    }
}

// Client Code
public class IteratorDemo {
    public static void main(String[] args) {
        BookList bookList = new BookList();
        bookList.addBook("The Lord of the Rings");
        bookList.addBook("Pride and Prejudice");
        bookList.addBook("The Hitchhiker's Guide to the Galaxy");

        Iterator iterator = bookList.createIterator();

        while (iterator.hasNext()) {
            String book = iterator.next();
            System.out.println(book);
        }
    }
}
