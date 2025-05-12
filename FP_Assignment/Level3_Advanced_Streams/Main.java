package FP_Assignment.Level3_Advanced_Streams;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // --- Data Setup ---
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> duplicateNumbers = Arrays.asList(1, 2, 1, 1, 1, 2, 3, 4, 5, 6, 1, 1, 9);
        List<String> names = Arrays.asList("Avi", "Akash", "Sakshi", "Rakesh", "Shivank");

        // ----------------------------------------------------------
        // 16. Group a list of names by their first letter using
        // Collectors.groupingBy().
        Map<String, List<String>> groupNamesByFirstLetter = names.stream()
                .collect(Collectors.groupingBy(name -> name.substring(0, 1)));
        System.out.println(groupNamesByFirstLetter);

        // ----------------------------------------------------------
        // 17. Partition a list of integers into even and odd using
        // Collectors.partitioningBy().
        Map<Boolean, List<Integer>> partitionedByParity = numbers.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));
        System.out.println(partitionedByParity);

        // ----------------------------------------------------------
        // 18. Join a list of strings into a single comma-separated string.
        String namesJoined = names.stream().collect(Collectors.joining(","));
        System.out.println(namesJoined);

        // ----------------------------------------------------------
        // 19. Find the first element in a list of integers that is divisible by 5 using
        // findFirst().
        Optional<Integer> firstNumberDivisibleByFive = numbers.stream().filter(num -> num % 5 == 0).findFirst();
        System.out.println(
                firstNumberDivisibleByFive.isPresent() ? firstNumberDivisibleByFive.get()
                        : "Number doesn't exists!");

        // ----------------------------------------------------------
        // 20. Use Optional to safely get a value or return a default.
        Optional<Integer> maxNumber = numbers.stream().max(Comparator.naturalOrder());
        System.out.println("Largest Number is: " + (maxNumber.isPresent() ? maxNumber.get() : -1));

        // ----------------------------------------------------------
        // 21. Convert a list of integers to a Set using Collectors.toSet().
        Set<Integer> uniqueNumberSet = duplicateNumbers.stream().collect(Collectors.toSet());
        System.out.println(uniqueNumberSet);
    }
}
