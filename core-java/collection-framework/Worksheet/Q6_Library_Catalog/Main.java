package Worksheet.Q6_Library_Catalog;

import java.util.*;

/*
Problem 6: Library Catalog (Map<String, Set<Book>>)
Each genre maps to a set of Book objects.
•	Prevent duplicate books using equals and hashCode.
•	Print all books in a genre, sorted by publication year.
 */

public class Main {
    public static void main(String[] args) {
        Map<String, Set<Book>> catalog = new HashMap<>();

        addBook(catalog, new Book("Dune", "Science Fiction", 1965, "Frank Herbert"));
        addBook(catalog, new Book("Neuromancer", "Science Fiction", 1984, "William Gibson"));
        addBook(catalog, new Book("Foundation", "Science Fiction", 1951, "Isaac Asimov"));
        addBook(catalog, new Book("The Hobbit", "Fantasy", 1937, "J.R.R. Tolkien"));
        addBook(catalog, new Book("Harry Potter", "Fantasy", 1997, "J.K. Rowling"));
        addBook(catalog, new Book("The Hobbit", "Fantasy", 1937, "J.R.R. Tolkien")); // Duplicate

        printBooksByGenre(catalog, "Fantasy");
        printBooksByGenre(catalog, "Science Fiction");
    }

    private static void addBook(Map<String, Set<Book>> catalog, Book book) {
        if (!catalog.containsKey(book.genre)) {
            catalog.put(book.genre, new HashSet<Book>());
        }
        Set<Book> bookSet = catalog.get(book.genre);
        bookSet.add(book);
    }

    private static void printBooksByGenre(Map<String, Set<Book>> catalog, String genre) {
        System.out.println("\nBooks in genre: " + genre);
        Set<Book> books = catalog.get(genre);
        if (books == null || books.isEmpty()) {
            System.out.println("No books found.");
            return;
        }

        books.stream()
                .sorted(Comparator.comparingInt(Book::getPublicationYear))
                .forEach(System.out::println);
    }
}
