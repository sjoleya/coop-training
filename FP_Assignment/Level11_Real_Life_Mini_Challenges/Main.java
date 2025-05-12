package FP_Assignment.Level11_Real_Life_Mini_Challenges;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    /*
     * i. Implement a text analyzer: given a paragraph, split into words, count
     * frequency of each word, and return a map.
     */
    public static Map<String, Long> analyzeText(String paragraph) {
        if (paragraph == null || paragraph.isEmpty()) {
            return Collections.emptyMap();
        }
        return Arrays.stream(paragraph.toLowerCase().split("[\\s.,]+"))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
    }

    /*
     * ii. Create a reusable method that filters a list based on a passed-in
     * Predicate<T> and logs each filtered item.
     */
    public static <T> List<T> filterAndLog(List<T> list, Predicate<T> predicate) {
        if (list == null || list.isEmpty() || predicate == null) {
            return Collections.emptyList();
        }
        List<T> filteredList = list.stream()
                .filter(predicate)
                .collect(Collectors.toList());
        filteredList.forEach(item -> System.out.println("Filtered item: " + item));
        return filteredList;
    }

    /*
     * iii. From a list of dates, return the earliest and latest date using a custom
     * comparator and stream operations.
     */
    public static List<Date> findEarliestAndLatestDate(List<String> dateStrings) {
        if (dateStrings == null || dateStrings.isEmpty()) {
            return Collections.emptyList();
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<Date> dates = dateStrings.stream()
                .map(dateString -> {
                    try {
                        return dateFormat.parse(dateString);
                    } catch (ParseException e) {
                        System.err.println("Invalid date format: " + dateString);
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .toList();

        if (dates.isEmpty()) {
            return Collections.emptyList();
        }

        Date earliestDate = dates.stream().min(Date::compareTo).orElse(null);
        Date latestDate = dates.stream().max(Date::compareTo).orElse(null);

        return Arrays.asList(earliestDate, latestDate);
    }

    /*
     * iv. Create a program that returns the top 3 longest strings from a list,
     * using streams.
     */
    public static List<String> findTop3LongestStrings(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            return Collections.emptyList();
        }
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .limit(3)
                .toList();
    }

    /*
     * v. Simulate a batch job: given a list of jobs (name, status),
     * return only failed job names in uppercase, sorted alphabetically.
     */
    public static List<String> findFailedJobs(List<Job> jobs) {
        if (jobs == null || jobs.isEmpty()) {
            return Collections.emptyList();
        }
        return jobs.stream()
                .filter(job -> "FAILED".equalsIgnoreCase(job.getStatus()))
                .map(Job::getName)
                .map(String::toUpperCase)
                .sorted()
                .toList();
    }

    public static void main(String[] args) throws ParseException {
        // Text Analyzer Example
        String paragraph = "This is a sample paragraph. This paragraph is used to test the text analyzer.";
        Map<String, Long> wordFrequencies = analyzeText(paragraph);
        System.out.println("Word Frequencies: " + wordFrequencies);

        // filterAndLog Example
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = filterAndLog(numbers, n -> n % 2 == 0);
        System.out.println("Even Numbers: " + evenNumbers);

        // findEarliestAndLatestDate Example
        List<String> dateStrings = Arrays.asList("2023-01-01", "2022-12-31", "2023-02-15", "2022-11-30");
        List<Date> dates = findEarliestAndLatestDate(dateStrings);
        if (!dates.isEmpty() && dates.get(0) != null && dates.get(1) != null) {
            System.out.println("Earliest Date: " + new SimpleDateFormat("yyyy-MM-dd").format(dates.get(0))
                    + ", Latest Date: " + new SimpleDateFormat("yyyy-MM-dd").format(dates.get(1)));
        } else {
            System.out.println("No valid dates found.");
        }

        // Top 3 Longest Example
        List<String> strings = Arrays.asList("apple", "banana", "kiwi", "orange", "grapefruit");
        List<String> top3LongestStrings = findTop3LongestStrings(strings);
        System.out.println("Top 3 Longest Strings: " + top3LongestStrings);

        // Batch Job Example
        List<Job> jobs = Arrays.asList(
                new Job("Job1", "SUCCESS"),
                new Job("Job2", "FAILED"),
                new Job("Job3", "SUCCESS"),
                new Job("Job4", "FAILED"));
        List<String> failedJobs = findFailedJobs(jobs);
        System.out.println("Failed Jobs: " + failedJobs);
    }
}