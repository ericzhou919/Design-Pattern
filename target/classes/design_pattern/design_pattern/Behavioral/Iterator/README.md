## 定義

提供一種在不暴露其底層表示的情況下，依序訪問聚集物件元素的方法。  

## 例子   

> 書櫃的書照著字母順序排列，依序讀取全部的書。  
  
## 程式碼範例  
創建Aggregate和Iterator介面。
```java
public interface Aggregate {
    public abstract Iterator iterator();
}

public interface Iterator {

    public abstract boolean hasNext();

    public abstract Object next();
}
```  

創建Book的Aggregate和Iterator。
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

程式執行：  
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

輸出：  
```java
A Book
B Book
C Book
D Book
```
