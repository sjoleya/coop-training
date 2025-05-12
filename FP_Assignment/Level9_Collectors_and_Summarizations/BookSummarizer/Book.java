package FP_Assignment.Level9_Collectors_and_Summarizations.BookSummarizer;

public class Book {
    private String title;
    private double rating;
    private double price;

    public Book(String title, double rating, double price) {
        this.title = title;
        this.rating = rating;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", rating=" + rating +
                ", price=" + price +
                '}';
    }
}
