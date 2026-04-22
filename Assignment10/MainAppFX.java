import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.ResultSet;

public class MainAppFX extends Application {

    TextArea output = new TextArea();

    public void start(Stage stage) {

        Button insertBtn = new Button("Insert Sample Data");
        Button selectBtn = new Button("View Menu Items");
        Button updateBtn = new Button("Update Price <=100 → 200");
        Button deleteBtn = new Button("Delete Items Starting with P");

        insertBtn.setOnAction(e -> {
            MenuItemDAO.insert("Pizza", 120, 1);
            MenuItemDAO.insert("Pasta", 90, 1);
            output.setText("Inserted sample data.");
        });

        selectBtn.setOnAction(e -> {
            try {
                ResultSet rs = MenuItemDAO.getAll();
                StringBuilder sb = new StringBuilder();

                sb.append("ID\tName\tPrice\tResId\n");
                sb.append("--------------------------------\n");

                while (rs.next()) {
                    sb.append(rs.getInt("Id")).append("\t")
                      .append(rs.getString("Name")).append("\t")
                      .append(rs.getDouble("Price")).append("\t")
                      .append(rs.getInt("ResId")).append("\n");
                }

                output.setText(sb.toString());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        updateBtn.setOnAction(e -> {
            MenuItemDAO.updatePrice(100);
            output.setText("Updated prices.");
        });

        deleteBtn.setOnAction(e -> {
            MenuItemDAO.deleteByName();
            output.setText("Deleted items starting with P.");
        });

        VBox root = new VBox(10, insertBtn, selectBtn, updateBtn, deleteBtn, output);
        Scene scene = new Scene(root, 400, 400);

        stage.setTitle("Restaurant JDBC JavaFX App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
