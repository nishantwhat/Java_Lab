import java.io.FileWriter;
import java.io.IOException;

public class AppendRowsCSV {
    public static void appendRows() {
        String csvFile = "Students.csv";
        try (FileWriter writer = new FileWriter(csvFile, true)) {
            writer.append("3,Pinky,ENTC,75,70,72,0,0,0\n");
            writer.append("4,Browny,MECH,68,65,70,0,0,0\n");
            writer.append("5,whitey,CIVIL,80,85,78,0,0,0\n");
            System.out.println("3 more rows appended with marks4 and marks5 as zero.");
        } catch (IOException e) {
            System.out.println("IOException occurred while appending rows: " + e.getMessage());
        }
    }
}
