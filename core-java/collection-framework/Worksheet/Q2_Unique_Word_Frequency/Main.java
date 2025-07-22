package Worksheet.Q2_Unique_Word_Frequency;

import java.util.Map;
import java.util.TreeMap;

/*
Problem 2: Unique Word Frequency Counter (Map, TreeSet)
Given a paragraph, calculate and print:
•	Number of unique words
•	Frequency of each word
•	Display words sorted alphabetically
 */

public class Main {
    public static void main(String[] args) {
        String paragraph = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        paragraph = paragraph.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "");
        String[] words = paragraph.split(" ");
        Map<String, Integer> wordCountMap = new TreeMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }
        System.out.println("Number of unique words: " + wordCountMap.size());
        System.out.println("Word Frequencies (sorted alphabetically):");
        wordCountMap.forEach((word, count) -> System.out.println(word + " : " + count));
    }
}
