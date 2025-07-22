package Worksheet.Q6_Library_Catalog;

import java.util.Objects;

public class Book {
    String title;
    String genre;
    int publicationYear;
    String author;

    public Book(String title, String genre, int publicationYear, String author) {
        this.title = title;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.author = author;
    }

    // Override equals and hashCode to prevent duplicates in Set
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Book book))
            return false;
        return publicationYear == book.publicationYear &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, publicationYear);
    }

    @Override
    public String toString() {
        return String.format("%s by %s (%d)", title, author, publicationYear);
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}
