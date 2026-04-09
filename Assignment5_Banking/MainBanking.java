import java.util.ArrayList;

public class MainBanking {
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Account> accounts = new ArrayList<>();

        // Create customers
        Customer c1 = new Customer(1, "Alice", "alice@email.com");
        Customer c2 = new Customer(2, "Bob", "bob@email.com");
        customers.add(c1);
        customers.add(c2);

        // Create accounts
        SavingsAccount sa1 = new SavingsAccount(1001, c1, 5000, 3.5);
        LoanAccount la1 = new LoanAccount(2001, c1, 0, 10000, 7.5);
        SavingsAccount sa2 = new SavingsAccount(1002, c2, 8000, 4.0);
        accounts.add(sa1);
        accounts.add(la1);
        accounts.add(sa2);

        // Perform some operations
        sa1.deposit(1000);
        sa1.withdraw(200);
        sa1.calculateInterest();
        la1.deposit(500);
        la1.calculateInterest();
        sa2.withdraw(1000);
        sa2.calculateInterest();

        // Display consolidated info for each customer
        for (Customer cust : customers) {
            System.out.println("\n" + cust);
            for (Account acc : accounts) {
                if (acc.getCustomer().getCustomerId() == cust.getCustomerId()) {
                    acc.displayAccountInfo();
                }
            }
        }
    }
}
