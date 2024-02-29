package logger;

import java.io.FileWriter;
import java.io.IOException;

public class CalculatorLogger {
    private static final String LOG_FILE_PATH = "calculator.log";

    public static void log(String message) {
        try (FileWriter writer = new FileWriter(LOG_FILE_PATH, true)) {
            writer.write(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}