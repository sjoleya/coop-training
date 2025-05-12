package FP_Assignment.Level7_Custom_Types_And_Nested_Streams.CsvStringToListInteger;

import java.util.Arrays;
import java.util.List;

/*
 * Convert a CSV string of numbers ("1,2,3,4") into a List<Integer> using streams and lambdas.
 */

public class Main {

    public static void main(String[] args) {
        // Sample data
        String csvString = "1,2,3,4";
        List<Integer> integers = convertCsvStringToListInteger(csvString);
        System.out.println(integers);
    }

    public static List<Integer> convertCsvStringToListInteger(String csvString) {
        return Arrays.stream(csvString.split(","))
                .map(Integer::parseInt)
                .toList();
    }
}