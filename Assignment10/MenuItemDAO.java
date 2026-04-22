import java.sql.*;

public class MenuItemDAO {

    public static void insert(String name, double price, int resId) {
        try (Connection con = DBConnection.getConnection()) {
            String q = "INSERT INTO MenuItem (Name, Price, ResId) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setInt(3, resId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getAll() throws Exception {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();

        return st.executeQuery("SELECT * FROM MenuItem");
    }

    public static void updatePrice(double price) {
        try (Connection con = DBConnection.getConnection()) {
            String q = "UPDATE MenuItem SET Price = 200 WHERE Price <= ?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setDouble(1, price);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteByName() {
        try (Connection con = DBConnection.getConnection()) {
            String q = "DELETE FROM MenuItem WHERE Name LIKE 'P%'";
            Statement st = con.createStatement();
            st.executeUpdate(q);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
