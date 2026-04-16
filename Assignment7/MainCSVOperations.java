public class MainCSVOperations {
    public static void main(String[] args) {
        System.out.println("--- Creating CSV and adding initial rows ---");
        CreateCSV.createCSV();

        System.out.println("--- Appending 3 more rows ---");
        AppendRowsCSV.appendRows();

        System.out.println("--- Updating marks4 and marks5 for a student ---");
        UpdateCSV.updateRows();

        System.out.println("--- Updating percentage for all students ---");
        UpdatePercentageCSV.updatePercentages();

        System.out.println("--- Deleting a student row ---");
        DeleteStudentCSV.deleteRow();
    }
}
