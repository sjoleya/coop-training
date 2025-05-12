package FP_Assignment.Level9_Collectors_and_Summarizations.BookSummarizer;

import java.util.List;
/*
Given a list of books, generate a summary object with total count, average rating, and total price.
 */

public class BookSummarizer {
    public static Summary summarizeBooks(List<Book> books) {
        if (books == null || books.isEmpty()) {
            return new Summary(0, 0, 0);
        }
        long totalCount = books.size();
        double averageRating = books.stream()
                .mapToDouble(Book::getRating)
                .average()
                .orElse(0);
        double totalPrice = books.stream()
                .mapToDouble(Book::getPrice)
                .sum();

        return new Summary(totalCount, averageRating, totalPrice);
    }

    public static void main(String[] args) {
        List<Book> bookList = List.of(
                new Book("The Lord of the Rings", 4.5, 25.0),
                new Book("Pride and Prejudice", 4.2, 15.0),
                new Book("1984", 4.7, 20.0));

        Summary summary = summarizeBooks(bookList);
        System.out.println("Book Summary: " + summary);
    }
}