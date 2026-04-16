import java.io.FileWriter;
import java.io.IOException;

public class CreateCSV {
    public static void createCSV() {
        String csvFile = "Students.csv";
        try (FileWriter writer = new FileWriter(csvFile)) {
            // header row
            writer.append("studentId,name,branch,marks1,marks2,marks3,marks4,marks5,percentage\n");
            // initial data rows
            writer.append("1,Appy,CSE,85,90,88,89,92,0\n");
            writer.append("2,Bluey,AIML,78,82,80,78,85,0\n");
            System.out.println("CSV file created and initial rows added successfully.");
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
    }
}
