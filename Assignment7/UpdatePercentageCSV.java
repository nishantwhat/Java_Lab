import java.io.*;
import java.util.*;

public class UpdatePercentageCSV {
    public static void updatePercentages() {
        String csvFile = "Students.csv";
        List<String[]> rows = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                // Skip header row for now, process only student rows
                if (!values[0].equals("studentId") && values.length >= 9) {
                    int total = 0;
                    int count = 0;
                    // marks1 to marks5 are columns 3 to 7 (index 3 to 7, 0-based)
                    for (int i = 3; i <= 7; i++) {
                        try {
                            total += Integer.parseInt(values[i]);
                            count++;
                        } catch (NumberFormatException e) {
                            // skip if not a number
                        }
                    }
                    double percentage = count > 0 ? (total / (count * 1.0)) : 0;
                    values[8] = String.format("%.2f", percentage); // update percentage column
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
            System.out.println("Percentages updated successfully.");
        } catch (IOException e) {
            System.out.println("Error writing CSV: " + e.getMessage());
        }
    }
}
