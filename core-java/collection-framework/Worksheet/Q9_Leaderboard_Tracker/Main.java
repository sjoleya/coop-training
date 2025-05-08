package Worksheet.Q9_Leaderboard_Tracker;

/*
Problem 9: Leaderboard Tracker (TreeSet, Comparator)
Track player scores using TreeSet<Player> sorted by score descending.
•	Update a player's score and maintain correct leaderboard order.
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Comparator<Player> scoreComparator = Comparator.comparing(Player::getScore).reversed()
                .thenComparing(Player::getName);
        TreeSet<Player> leaderboard = new TreeSet<>(scoreComparator);

        leaderboard.add(new Player("Alice", 120));
        leaderboard.add(new Player("Bob", 150));
        leaderboard.add(new Player("Charlie", 100));

        System.out.println("Initial Leaderboard:");
        printLeaderboard(leaderboard);

        // Updating player's data
        updateScore(leaderboard, "Alice", 160);
        updateScore(leaderboard, "Charlie", 200);

        System.out.println("\nUpdated Leaderboard:");
        printLeaderboard(leaderboard);
    }

    private static void printLeaderboard(Set<Player> leaderboard) {
        for (Player p : leaderboard) {
            System.out.println(p);
        }
    }

    private static void updateScore(Set<Player> leaderboard, String name, int newScore) {
        Player dummy = new Player(name, 0);

        for (Player p : leaderboard) {
            if (p.equals(dummy)) {
                leaderboard.remove(p);
                p.setScore(newScore);
                leaderboard.add(p);
                break;
            }
        }
    }
}
