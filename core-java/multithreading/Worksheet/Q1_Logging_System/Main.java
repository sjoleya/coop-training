package Worksheet.Q1_Logging_System;

/*
You're building a high-throughput logging system for a large-scale application. Logs are generated from various parts of the system and should be stored in the order received, without blocking the producers.
Requirements:
Part 1: Basic Logging System
Implement a class Logger with the following features:
- Method: void log(String message)
- Accepts log messages from multiple threads concurrently.
- Stores the messages in the order they were received.
- Uses a separate thread to flush logs every 5 seconds to the console (simulate disk).

Part 2: Graceful Shutdown
- Provide a method void shutdown() that:
- Ensures all pending logs are flushed.
- Terminates the logging thread cleanly.

Part 3: Stress Simulation
Simulate 100 threads each logging 100 messages.
Ensure that the messages do not get lost or printed out of order.

Bonus Requirements:
- Support log levels (INFO, WARN, ERROR)
- Add timestamps to log entries
- Provide optional file-based flushing instead of console (via configuration)
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Logging System Test (File Output Only)...");

        String logFilePath = Logger.DEFAULT_LOG_FILE_PATH;
        int numProducerTasks = 100;
        int messagesPerTask = 100;
        int producerThreadPoolSize = 10;

        Logger logger = new Logger();
        System.out.println("Logger configured for FILE output: " + logFilePath);
        ExecutorService producerExecutor = Executors.newFixedThreadPool(producerThreadPoolSize);
        System.out.println("Simulating " + numProducerTasks + " producer tasks, each logging " +
                messagesPerTask + " messages, using a pool of " + producerThreadPoolSize + " threads.");

        long testStartTime = System.currentTimeMillis();
        for (int i = 0; i < numProducerTasks; i++) {
            final int taskId = i;
            producerExecutor.submit(() -> {
                for (int j = 0; j < messagesPerTask; j++) {
                    LogLevel level;
                    if (j % 30 == 0) level = LogLevel.ERROR;
                    else if (j % 15 == 0) level = LogLevel.WARN;
                    else level = LogLevel.INFO;
                    logger.log(level, "Log message " + j + " from task " + taskId + ".");
                }
            });
        }

        System.out.println("All producer tasks submitted. Waiting for completion...");
        producerExecutor.shutdown();
        try {
            if (!producerExecutor.awaitTermination(60, TimeUnit.SECONDS)) { // Adjust timeout as needed
                System.err.println("Producer tasks did not complete in time!");
                producerExecutor.shutdownNow();
            } else {
                System.out.println("All producer tasks have completed their logging operations.");
            }
        } catch (InterruptedException e) {
            System.err.println("Producer executor interrupted.");
            producerExecutor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        long testEndTime = System.currentTimeMillis();
        System.out.println("Producer tasks finished in " + (testEndTime - testStartTime) + " ms.");
        System.out.println("Log queue size before logger shutdown: " + logger.getQueueSize());

        logger.shutdown();

        System.out.println("--- Logging System Test Finished ---");
        long totalMessagesExpected = (long) numProducerTasks * messagesPerTask;
        System.out.println("Total messages expected to be logged: " + totalMessagesExpected);
    }
}
