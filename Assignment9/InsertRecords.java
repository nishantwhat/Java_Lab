import java.sql.*;

public class InsertRecords {

    public static void execute() {
        try (Connection con = DBConnection.getConnection()) {

            String resQuery = "INSERT INTO Restaurant (Name, Address) VALUES (?, ?)";
            PreparedStatement ps1 = con.prepareStatement(resQuery);

            for (int i = 1; i <= 10; i++) {
                ps1.setString(1, "Restaurant_" + i);
                ps1.setString(2, "City_" + i);
                ps1.executeUpdate();
            }

            String menuQuery = "INSERT INTO MenuItem (Name, Price, ResId) VALUES (?, ?, ?)";
            PreparedStatement ps2 = con.prepareStatement(menuQuery);

            for (int i = 1; i <= 10; i++) {
                ps2.setString(1, "Item_" + i);
                ps2.setDouble(2, i * 20);
                ps2.setInt(3, (i % 10) + 1);
                ps2.executeUpdate();
            }

            System.out.println("Inserted 10 records in both tables.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
