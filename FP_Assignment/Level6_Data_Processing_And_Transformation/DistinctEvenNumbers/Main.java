package FP_Assignment.Level6_Data_Processing_And_Transformation.DistinctEvenNumbers;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(5, 6, 7, 8),
                Arrays.asList(9, 10, 11, 12));

        List<Integer> distinctEvenNumbers = listOfLists.stream()
                .flatMap(List::stream)
                .filter(number -> number % 2 == 0)
                .distinct()
                .toList();

        System.out.println("Distinct even numbers: " + distinctEvenNumbers);
    }
}