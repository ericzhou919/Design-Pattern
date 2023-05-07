## Definition

Provide a method for sequentially accessing the elements of a collection object without exposing its underlying representation.

## Example

> The books in the bookcase are arranged in alphabetical order, and are read sequentially in their entirety.

## Programmatic Example

Create Aggregate and Iterator interfaces.

```java
public interface Aggregate {
    public abstract Iterator iterator();
}

public interface Iterator {

    public abstract boolean hasNext();

    public abstract Object next();
}
```

Create Aggregate and Iterator for Book.

```java
public class Book {
    private String name = "";

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class BookShelf implements Aggregate {
    private Book[] books;
    private int last = 0;

    public BookShelf(int maxsize) {
        this.books = new Book[maxsize];
    }

    public Book getBookAt(int index) {
        return books[index];
    }

    public void appendBook(Book book) {
        this.books[last] = book;
        last++;
    }

    public int getLength() {
        return last;
    }

    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}

public class BookShelfIterator implements Iterator {
    private BookShelf bookShelf;
    private int index;
    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }
    public boolean hasNext() {
        if (index < bookShelf.getLength()) {
            return true;
        } else {
            return false;
        }
    }
    public Object next() {
        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
}
```

Program execution：

```java
BookShelf bookShelf = new BookShelf(4);
bookShelf.appendBook(new Book("A Book"));
bookShelf.appendBook(new Book("B Book"));
bookShelf.appendBook(new Book("C Book"));
bookShelf.appendBook(new Book("D Book"));

Iterator it = bookShelf.iterator();
while (it.hasNext()) {
    Book book = (Book) it.next();
    System.out.println("" + book.getName());
}
```

Program output：

```java
A Book
B Book
C Book
D Book
```
