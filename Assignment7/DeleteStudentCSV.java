import java.io.*;
import java.util.*;

public class DeleteStudentCSV {
    public static void deleteRow() {
        String csvFile = "Students.csv";
        String targetStudentId = "3"; // Change this to the studentId you want to delete
        List<String[]> rows = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                // Keep header or rows not matching the target studentId
                if (values[0].equals("studentId") || !values[0].equals(targetStudentId)) {
                    rows.add(values);
                }
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
            System.out.println("Row deleted successfully (if present).");
        } catch (IOException e) {
            System.out.println("Error writing CSV: " + e.getMessage());
        }
    }
}
