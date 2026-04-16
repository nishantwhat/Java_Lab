import java.io.*;
import java.util.*;

public class UpdateCSV {
    public static void updateRows() {
        String csvFile = "Students.csv";
        List<String[]> rows = new ArrayList<>();
        String line;
        // Specify the studentId to update and the new marks4 and marks5 values
        String targetStudentId = "3"; // studentId of the row to update
        String newMarks4 = "88";
        String newMarks5 = "91";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                // Skip header row
                if (!values[0].equals("studentId") && values.length >= 9) {
                    if (values[0].equals(targetStudentId)) {
                        values[6] = newMarks4;
                        values[7] = newMarks5;
                    }
                }
                rows.add(values);
            }
        } catch (IOException e) {
            System.out.println("Error reading CSV: " + e.getMessage());
            return;
        }
        // Write updated data back to CSV
        try (FileWriter writer = new FileWriter(csvFile)) {
            for (String[] row : rows) {
                writer.append(String.join(",", row)).append("\n");
            }
            System.out.println("CSV updated successfully.");
        } catch (IOException e) {
            System.out.println("Error writing CSV: " + e.getMessage());
        }
    }
}
