package Worksheet.Q12_Voting_System;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Problem 12: Voting System (Map<String, Integer>)
Build a voting system that:
•	Tallies votes per candidate
•	Sorts by vote count descending
 */

public class Main {
    public static void main(String[] args) {
        List<String> votes = Arrays.asList("Alice", "Bob", "Alice", "Charlie", "Bob", "Bob", "Alice");

        Map<String, Integer> voteCounts = new HashMap<>();
        for (String vote : votes) {
            voteCounts.put(vote, voteCounts.getOrDefault(vote, 0) + 1);
        }

        List<Map.Entry<String, Integer>> sortedCandidates = new ArrayList<>(voteCounts.entrySet());
        sortedCandidates.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("\nVoting Results:");
        for (Map.Entry<String, Integer> entry : sortedCandidates) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }
}
