import java.sql.*;

public class SelectPriceLessThan100 {

    public static void execute() {
        try (Connection con = DBConnection.getConnection()) {

            String query = "SELECT * FROM MenuItem WHERE Price <= 100";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("\nItems with Price <= 100");
            System.out.println("ID\tName\tPrice\tResId");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("Id") + "\t" +
                        rs.getString("Name") + "\t" +
                        rs.getDouble("Price") + "\t" +
                        rs.getInt("ResId")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
