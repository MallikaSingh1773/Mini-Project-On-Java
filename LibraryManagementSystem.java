import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean checkedOut;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.checkedOut = false;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public boolean checkOut() {
        if (!checkedOut) {
            checkedOut = true;
            return true;
        }
        return false;
    }

    public boolean checkIn() {
        if (checkedOut) {
            checkedOut = false;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String status = checkedOut ? "Checked Out" : "Available";
        return title + " by " + author + " (" + isbn + ") - " + status;
    }
}

class Patron {
    private String name;
    private List<Book> checkedOutBooks;

    public Patron(String name) {
        this.name = name;
        this.checkedOutBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    public void checkOutBook(Book book) {
        if (!book.isCheckedOut()) {
            book.checkOut();
            checkedOutBooks.add(book);
        }
    }

    public void returnBook(Book book) {
        if (checkedOutBooks.contains(book)) {
            book.checkIn();
            checkedOutBooks.remove(book);
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Book book1 = new Book("Book1", "Author1", "ISBN1");
        Book book2 = new Book("Book2", "Author2", "ISBN2");
        Book book3 = new Book("Book3", "Author3", "ISBN3");

        Patron patron1 = new Patron("Patron1");
        Patron patron2 = new Patron("Patron2");

        patron1.checkOutBook(book1);
        patron1.checkOutBook(book2);
        patron2.checkOutBook(book3);

        System.out.println("Books checked out by Patron1:");
        for (Book book : patron1.getCheckedOutBooks()) {
            System.out.println(book);
        }

        System.out.println("Books checked out by Patron2:");
        for (Book book : patron2.getCheckedOutBooks()) {
            System.out.println(book);
        }
    }
}
