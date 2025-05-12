package FP_Assignment.Level5_Custom_Functional_Interfaces.TriFunction;

public class TriFunctionExample {
    public static void main(String[] args) {
        // TriFunction to calculate final price
        TriFunction<Double, Double, Double, Double> calculateFinalPrice = (basePrice, taxRate, discount) -> {
            double priceWithTax = basePrice + (basePrice * taxRate);
            return priceWithTax - discount;
        };

        double base = 100.0;
        double tax = 0.1; // 10% tax
        double discount = 15.0; // ₹15 discount

        double finalPrice = calculateFinalPrice.apply(base, tax, discount);
        System.out.println("Final Price: ₹" + finalPrice);
    }
}
