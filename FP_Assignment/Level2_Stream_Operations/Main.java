package FP_Assignment.Level2_Stream_Operations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // --- Data Setup ---
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<String> names = Arrays.asList("Avi", "Akash", "Jhanvi", "Rakesh", "Shivank");

        // ----------------------------------------------------------
        // 8. Filter a list of integers to only even numbers.
        List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).toList();
        System.out.println("List with only even numbers: " + evenNumbers);

        // ----------------------------------------------------------
        // 9. Convert a list of strings to uppercase using map().
        List<String> namesUppercase = names.stream().map(name -> name.toUpperCase()).toList();
        System.out.println("Names in Uppercase: " + namesUppercase);

        // ----------------------------------------------------------
        // 10. Given a list of names, return a list of names longer than 4 characters.
        List<String> namesWithLengthMoreThanFour = names.stream().filter(name -> name.length() > 4).toList();
        System.out.println("Names with Length more than 4 characters: " + namesWithLengthMoreThanFour);

        // ----------------------------------------------------------
        // 11. Count how many strings in a list start with “S”.
        long numberOfStringsWithLengthMoreThanFour = names.stream().filter(name -> name.length() > 4).count();
        System.out.println(numberOfStringsWithLengthMoreThanFour);

        // ----------------------------------------------------------
        // 12. Find the longest string in a list using reduce().
        String longestName = names.stream().reduce("",
                (name1, name2) -> name1.length() > name2.length() ? name1 : name2);
        System.out.println("Longest Name is: " + longestName);

        // ----------------------------------------------------------
        // 13. Sort a list of integers in descending order using streams.
        List<Integer> numsDescending = numbers.stream().sorted(Comparator.comparingInt(x -> (int) x).reversed())
                .collect(Collectors.toList());
        System.out.println("Numbers printed in Descending Order: " + numsDescending);

        // ----------------------------------------------------------
        // 14. Sort a list of integers in descending order using streams.
        List<Integer> numsSquared = numbers.stream().map(x -> x * x).toList();
        System.out.println("Numbers Squared: " + numsSquared);

        // ----------------------------------------------------------
        // 15. From a list of words, create a list of their lengths.
        List<Integer> lengthsofStrings = names.stream().map((name) -> name.length()).toList();
        System.out.println("List with Lengths of String: " + lengthsofStrings);

    }
}
