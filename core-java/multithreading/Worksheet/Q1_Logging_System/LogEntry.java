package Worksheet.Q1_Logging_System;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogEntry {
    final String timestamp;
    final LogLevel level;
    final String message;

    public LogEntry(LogLevel level, String message) {
        this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        this.level = level;
        this.message = message;
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] [" + level + "] " + message;
    }
}
