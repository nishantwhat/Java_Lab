import java.sql.*;

public class SelectCafeJavaItems {

    public static void execute() {
        try (Connection con = DBConnection.getConnection()) {

            String query = "SELECT m.* FROM MenuItem m " +
                    "JOIN Restaurant r ON m.ResId = r.Id " +
                    "WHERE r.Name = 'Cafe Java'";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("\nItems in Cafe Java");
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
