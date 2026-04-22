import java.sql.*;

public class DeleteItemsStartingWithP {

    public static void execute() {
        try (Connection con = DBConnection.getConnection()) {

            String query = "DELETE FROM MenuItem WHERE Name LIKE 'P%'";
            Statement stmt = con.createStatement();

            int rows = stmt.executeUpdate(query);
            System.out.println("\nDeleted Rows: " + rows);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
