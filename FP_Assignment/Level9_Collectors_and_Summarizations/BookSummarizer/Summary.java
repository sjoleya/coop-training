package FP_Assignment.Level9_Collectors_and_Summarizations.BookSummarizer;

public class Summary {
    private long totalCount;
    private double averageRating;
    private double totalPrice;

    public Summary(long totalCount, double averageRating, double totalPrice) {
        this.totalCount = totalCount;
        this.averageRating = averageRating;
        this.totalPrice = totalPrice;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Summary{" +
                "totalCount=" + totalCount +
                ", averageRating=" + averageRating +
                ", totalPrice=" + totalPrice +
                '}';
    }
}