package Worksheet.Q7_Movies_Ratings;

import java.util.*;
import java.util.stream.Collectors;

/*
Problem 7: Movie Rating Aggregator (Map, List)
Users rate movies between 1-5.
•	Store movie name -> list of ratings.
•	Compute and display average rating per movie sorted descending.
 */

public class Main {
    public static void main(String[] args) {
        Map<String, List<Integer>> ratingsMap = new HashMap<>();

        addRating(ratingsMap, "Inception", 5);
        addRating(ratingsMap, "Inception", 4);
        addRating(ratingsMap, "Interstellar", 5);
        addRating(ratingsMap, "Interstellar", 5);
        addRating(ratingsMap, "The Matrix", 4);
        addRating(ratingsMap, "The Matrix", 3);
        addRating(ratingsMap, "The Matrix", 5);

        List<Map.Entry<String, Double>> averageRatings = ratingsMap.entrySet().stream()
                .map(entry -> Map.entry(entry.getKey(), calculateAverage(entry.getValue())))
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .collect(Collectors.toList());

        System.out.println("Movie Ratings (Highest First):");
        for (Map.Entry<String, Double> entry : averageRatings) {
            System.out.printf("%s: %.2f%n", entry.getKey(), entry.getValue());
        }
    }

    private static void addRating(Map<String, List<Integer>> map, String movie, int rating) {
        map.computeIfAbsent(movie, _ -> new ArrayList<>()).add(rating);
    }

    private static double calculateAverage(List<Integer> ratings) {
        return ratings.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }
}
