package Worksheet.Q4_Thread_Pool_Image_Processor;

/*
Assignment 4: Thread Pool Image Processor
Background:
Simulate a parallel image processing pipeline using Java’s ExecutorService.

Requirements:
- Given 50 image IDs (1–50), simulate processing (sleep 100ms)
- Return a message "Image X processed" for each
- Collect and print results in order using Callable + Future

Bonus Requirements:
- Use a fixed thread pool of size 5
- Measure total execution time
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        int numberOfImages = 50;
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future<String>> futures = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        // Submit Tasks
        for(int index = 1; index <= numberOfImages; index++) {
            Callable<String> task = new ImageProcessor(index);
            Future<String> future = executorService.submit(task);
            futures.add(future);
        }

        // Collect and print results in order
        for(Future<String> future : futures) {
            try {
                String result = future.get();
                System.out.println(result);
            } catch (ExecutionException e) {
                System.err.println("Error processing image: " + e.getCause().getMessage());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread was interrupted while waiting for result.");
            }
        }

        // Gracefully shut down service
        executorService.shutdown();
        try {
            if(!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) + " ms");
    }
}
