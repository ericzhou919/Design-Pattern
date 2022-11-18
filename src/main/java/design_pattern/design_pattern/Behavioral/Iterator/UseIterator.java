package design_pattern.design_pattern.Behavioral.Iterator;

public class UseIterator {
    public static void UseIterator() {
        System.out.println("UseIterator");
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
    }

}
