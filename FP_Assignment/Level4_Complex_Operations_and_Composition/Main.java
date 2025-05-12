package FP_Assignment.Level4_Complex_Operations_and_Composition;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // --- Data Setup ---
        List<String> words = Arrays.asList("apple", "banana", "cherry", "banana", "date", "fig", "grape");
        List<String> strings = Arrays.asList("hello", "world", "java", "stream", "api");
        List<Integer> numbers = Arrays.asList(2, 3, 4, 6, 8, 9, 10);
        List<Person> people = Arrays.asList(
                new Person("Avinash", 23),
                new Person("Vishnu", 17),
                new Person("Chirag", 31),
                new Person("Dev", 16));

        // ----------------------------------------------------------
        // 22. Write a function that takes a list of strings and returns a map of word
        // to its length.
        Map<String, Integer> wordLengths = words.stream()
                .collect(Collectors.toMap(word -> word, word -> word.length(), (v1, v2) -> v1));
        System.out.println("Word lengths: " + wordLengths);

        // ----------------------------------------------------------
        // 23. Compose two functions: one that converts string to uppercase and one that
        // appends “!”.
        Function<String, String> toUpperCase = str -> str.toUpperCase();
        Function<String, String> addExclamation = str -> str + "!";
        Function<String, String> composedFunction = toUpperCase.andThen(addExclamation);

        System.out.println("Composed: " + composedFunction.apply("hello"));

        // ----------------------------------------------------------
        // 24. Chain multiple stream operations: filter > map > sort > collect.
        List<String> filteredMappedSorted = strings.stream()
                .filter(s -> s.length() > 4)
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Filtered, mapped, sorted: " + filteredMappedSorted);

        // ----------------------------------------------------------
        // 25. Given a list of people (name, age), filter adults (age > 18) and collect
        // names.
        List<String> adultNames = people.stream()
                .filter(p -> p.age > 18)
                .map(p -> p.name)
                .collect(Collectors.toList());
        System.out.println("Adult names: " + adultNames);

        // ----------------------------------------------------------
        // 26. From a list of words, remove duplicates and return sorted result.
        List<String> uniqueSortedWords = words.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Unique sorted words: " + uniqueSortedWords);

        // ----------------------------------------------------------
        // 27. Compute the average length of strings in a list.
        double averageLength = strings.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0);
        System.out.println("Average string length: " + averageLength);

        // ----------------------------------------------------------
        // 28. Find the product of all even numbers in a list using reduce().
        int productOfEvens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .reduce(1, (a, b) -> a * b);
        System.out.println("Product of even numbers: " + productOfEvens);
    }
}
