public class MainApp {

    public static void main(String[] args) {

        System.out.println("===== JDBC CRUD OPERATIONS =====");

        InsertRecords.execute();
        SelectPriceLessThan100.execute();
        SelectCafeJavaItems.execute();
        UpdatePrice.execute();
        DeleteItemsStartingWithP.execute();

        System.out.println("\n===== OPERATIONS COMPLETED =====");
    }
}
