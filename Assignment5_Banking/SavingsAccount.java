public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(int accountNumber, Customer customer, double balance, double interestRate) {
        super(accountNumber, customer, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        // Optionally, add logic specific to savings account
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn from Savings: " + amount);
        } else {
            System.out.println("Invalid or insufficient funds for withdrawal in Savings Account.");
        }
    }

    public void calculateInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Interest added: " + interest);
    }

    @Override
    public void displayAccountInfo() {
        System.out.println("[Savings Account] " + accountNumber + ", Balance: " + balance + ", Interest Rate: " + interestRate + "%");
    }
}
