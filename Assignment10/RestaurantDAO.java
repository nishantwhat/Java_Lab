
import java.sql.*;

public class RestaurantDAO {

    public static void insert(String name, String address) {
        try (Connection con = DBConnection.getConnection()) {
            String q = "INSERT INTO Restaurant (Name, Address) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, name);
            ps.setString(2, address);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getAll() throws Exception {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        return st.executeQuery("SELECT * FROM Restaurant");
    }
}
