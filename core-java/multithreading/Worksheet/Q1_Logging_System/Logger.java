package Worksheet.Q1_Logging_System;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Logger {
    private final BlockingQueue<LogEntry> logQueue = new LinkedBlockingQueue<>();
    private final ScheduledExecutorService flushScheduler;
    private volatile boolean serviceRunning = true;
    private final PrintWriter fileWriter;

    // Configuration Constants
    public static final long FLUSH_INTERVAL_SECONDS = 5;
    public static final String DEFAULT_LOG_FILE_PATH = "src/Worksheet/Q1_Logging_System/files/logs.txt";

    public Logger() {
        try {
            fileWriter = new PrintWriter(DEFAULT_LOG_FILE_PATH);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Failed to open log file", e);
        }
        this.flushScheduler = Executors.newSingleThreadScheduledExecutor(r -> {
            Thread t = new Thread(r, "LoggerFlushThread");
            t.setDaemon(true); // Background Process should not affect JVM exit
            return t;
        });
        flushScheduler.scheduleAtFixedRate(this::flushLogs, FLUSH_INTERVAL_SECONDS, FLUSH_INTERVAL_SECONDS,
                TimeUnit.SECONDS);
    }

    private void flushLogs() {
        List<LogEntry> entriesToFlush = new ArrayList<>();
        logQueue.drainTo(entriesToFlush);

        if (!entriesToFlush.isEmpty()) {
            // System.out.println("--- Flushing " + entriesToFlush.size() + " logs to FILE:
            // " + logFilePath + " ---"); // Debug
            for (LogEntry entry : entriesToFlush) {
                fileWriter.println(entry.toString());
            }
            fileWriter.flush();
        }
    }

    public void log(LogLevel level, String message) {
        if (!serviceRunning && logQueue.isEmpty()) {
            // Logger is shutting down or shut down, and queue is empty. Silently ignore new
            // logs.
            return;
        }
        try {
            LogEntry entry = new LogEntry(level, message);
            logQueue.put(entry);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Logging thread interrupted while enqueuing log. Message may be lost: " + message);
        }
    }

    public void shutdown() {
        System.out.println("Logger shutdown sequence initiated");
        serviceRunning = false;

        flushScheduler.shutdown();
        try {
            if (!flushScheduler.awaitTermination(FLUSH_INTERVAL_SECONDS + 2, TimeUnit.SECONDS)) {
                System.err.println("Logger flush scheduler did not terminate in time. Forcing...");
                flushScheduler.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.err.println("Logger shutdown interrupted while waiting for flush scheduler.");
            flushScheduler.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("Performing final flush of " + logQueue.size() + " pending log(s)...");
        flushLogs(); // Final flush

        fileWriter.close();
        if (fileWriter.checkError()) {
            System.err.println("Error flagged on PrintWriter after closing file: " + DEFAULT_LOG_FILE_PATH);
        }
        System.out.println("Log file writer closed. Logger shutdown completed");
    }

    public int getQueueSize() {
        return logQueue.size();
    }

}
