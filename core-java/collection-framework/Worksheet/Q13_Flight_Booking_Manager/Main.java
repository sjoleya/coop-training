package Worksheet.Q13_Flight_Booking_Manager;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<String> bookingQueue = new LinkedList<>();
        bookingQueue.add("Alice");
        bookingQueue.add("Bob");
        bookingQueue.add("Charlie");

        Map<String, String> confirmedBookings = new LinkedHashMap<>();

        int seatCounter = 1;

        while (!bookingQueue.isEmpty()) {
            String passenger = bookingQueue.poll();
            String seatNumber = "Seat-" + seatCounter++;
            confirmedBookings.put(passenger, seatNumber);
            System.out.println("Confirmed booking: " + passenger + " -> " + seatNumber);
        }

        System.out.println("\nFinal Confirmed Bookings:");
        for (Map.Entry<String, String> entry : confirmedBookings.entrySet()) {
            System.out.println(entry.getKey() + " is assigned to " + entry.getValue());
        }
    }
}
