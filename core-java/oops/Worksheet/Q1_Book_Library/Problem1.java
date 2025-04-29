package Worksheet.Q1_Book_Library;

import java.util.ArrayList;

/*
Create a `Book` class with fields `title`, `author`, and `ISBN`. Include a constructor and a method to
print details. Then, create a `Library` class to store a list of books and a method to search for a book
by title.
 */

class Book {
    String title;
    String author;
    String ISBNCode;

    public Book(String title, String author, String ISBNCode) {
        this.title = title;
        this.author = author;
        this.ISBNCode = ISBNCode;
    }
    public String printDetails() {
        return "Title: " + title + "\nAuthor: " + author + "\nISBN: " + ISBNCode;
    }
}

class Library {
    private final ArrayList<Book> _books = new ArrayList<>();

    public Library() {
        // Adding a dummy list of books
        _books.add(new Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084"));
        _books.add(new Book("1984", "George Orwell", "978-0451524935"));
        _books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565"));
        _books.add(new Book("One Hundred Years of Solitude", "Gabriel Garcia Marquez", "978-0061120084"));
        _books.add(new Book("Brave New World", "Aldous Huxley", "978-0060850524"));
    }
    public void addBook(Book book) {
        _books.add(book);
    }
    public boolean findBookByTitle(String title) {
        for(Book book : _books) {
            if(book.title.equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }
}

public class Problem1 {
    public static void main(String[] args) {
        Library library = new Library();

        String searchTitle1 = "1984";
        boolean found1 = library.findBookByTitle(searchTitle1);
        System.out.println("Is '" + searchTitle1 + "' in the library? " + found1);

        String searchTitle2 = "The Hitchhiker's Guide to the Galaxy";
        boolean found2 = library.findBookByTitle(searchTitle2);
        System.out.println("Is '" + searchTitle2 + "' in the library? " + found2);
    }
}