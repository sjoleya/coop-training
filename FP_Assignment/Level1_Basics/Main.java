package FP_Assignment.Level1_Basics;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        // ----------------------------------------------------------
        // 1. Write a Predicate<String> that returns true if a string starts with “A”.
        Predicate<String> startsWithA = (string) -> (string.startsWith("A"));
        System.out.println(startsWithA.test("Sarthak"));
        System.out.println(startsWithA.test("Aman"));

        // ----------------------------------------------------------
        // 2. Create a Function<String, Integer> that returns the length of a string.
        Function<String, Integer> lengthString = string -> string.length();
        System.out.println(lengthString.apply("Ram"));

        // ----------------------------------------------------------
        // 3. Use a Consumer<String> to print a string in uppercase.
        Consumer<String> printUpper = s -> System.out.println(s.toUpperCase());
        printUpper.accept("shyam");

        // ----------------------------------------------------------
        // 4. Write a Supplier<Double> that generates a random number.
        Supplier<Double> getRandomNumber = () -> Math.random();
        System.out.println(getRandomNumber.get());

        // ----------------------------------------------------------
        // 5. Use a lambda expression to sort a list of strings alphabetically.
        List<String> names = Arrays.asList("Ravi", "Akash", "Jhanvi");
        names.sort((name1, name2) -> name1.compareTo(name2));
        System.out.println(names);

        // ----------------------------------------------------------
        // 6. Create a BiFunction<Integer, Integer, Integer> that returns the sum.
        BiFunction<Integer, Integer, Integer> addTwoNumbers = (a, b) -> a + b;
        System.out.println(addTwoNumbers.apply(6, 9));

        // ----------------------------------------------------------
        // 7. Create a Runnable lambda that prints “Hello Functional Java”.
        Runnable helloRunnable = () -> System.out.println("Hello Functional Java");
        helloRunnable.run();
    }
}
