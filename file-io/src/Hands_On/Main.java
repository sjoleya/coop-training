package Hands_On;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String path = "src/Hands_On/";
        String inputFileName = path + "server.log";
        String outputFileName = path + "summary.txt";
        if (args.length == 2) {
            inputFileName = args[0];
            outputFileName = args[1];
            System.out.println("Using provided files -> Input: " + inputFileName + ", Output: " + outputFileName);
        } else if (args.length != 0) {
            System.err.println("Usage: java LogFileAnalyzer [<input_file> <output_file>]");
            System.err.println("If no arguments are provided, defaults will be used (" + inputFileName + ", "
                    + outputFileName + ")");
            System.exit(1);
        }

        int totalLines = 0;
        int errorLines = 0;
        int warningLines = 0;

        // -----------------------------------------------------
        // 1. READ and ANALYZE the file
        // -----------------------------------------------------
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                totalLines++;

                if (currentLine.contains("ERROR")) {
                    errorLines++;
                }
                if (currentLine.contains("WARNING")) {
                    warningLines++;
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("Error: Input File not found: " + inputFileName);
            return;
        } catch (IOException e) {
            System.err.println("Error reading file '" + inputFileName + "': " + e.getMessage());
            return;
        } catch (Exception e) {
            System.err.println("An unexpected error occurred during reading: " + e.getMessage());
            return;
        }

        // -----------------------------------------------------
        // 2. WRITE the summary report
        // -----------------------------------------------------
        try (PrintWriter writer = new PrintWriter(outputFileName)) {
            writer.println("Log Summary Report");
            writer.println("------------------");
            writer.println("Total log entries: " + totalLines);
            writer.println("ERROR entries:   " + errorLines);
            writer.println("WARNING entries: " + warningLines);
            writer.println("------------------");

            if (totalLines > 0) {
                double errorPercentage = ((double) errorLines / totalLines) * 100.0;
                double warningPercentage = ((double) warningLines / totalLines) * 100.0;
                writer.printf("ERROR percentage:   %.2f%%\n", errorPercentage);
                writer.printf("WARNING percentage: %.2f%%\n", warningPercentage);
            }
            System.out.println("Summary Report successfully generated: " + outputFileName);
        } catch (IOException e) {
            System.err.println("Error writing to file '" + outputFileName + "': " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred during writing: " + e.getMessage());
        }
    }
}
