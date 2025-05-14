package Worksheet.Q7;

/*
 * 7. Write a `try-with-resources` block where two custom resources both throw exceptions in `close()`.
 *    Capture and display the suppressed exceptions from the primary one.
 */

public class Question7 {

    public static void main(String[] args) {
        try (CustomResource1 res1 = new CustomResource1();
                CustomResource2 res2 = new CustomResource2()) {
            // Use resources
            System.out.println("Using resources...");
        } catch (Exception e) {
            System.err.println("Main exception: " + e.getMessage());
            Throwable[] suppressed = e.getSuppressed();
            if (suppressed != null) {
                for (Throwable t : suppressed) {
                    System.err.println("Suppressed exception: " + t.getMessage());
                }
            }
        }
    }
}