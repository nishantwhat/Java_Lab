public class LoanAccount extends Account {
    private double loanAmount;
    private double interestRate;

    public LoanAccount(int accountNumber, Customer customer, double balance, double loanAmount, double interestRate) {
        super(accountNumber, customer, balance);
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        // Optionally, add logic specific to loan account
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawals are not allowed from a Loan Account.");
    }

    public void calculateInterest() {
        double interest = loanAmount * interestRate / 100;
        System.out.println("Loan Interest: " + interest);
    }

    @Override
    public void displayAccountInfo() {
        System.out.println("[Loan Account] " + accountNumber + ", Balance: " + balance + ", Loan Amount: " + loanAmount + ", Interest Rate: " + interestRate + "%");
    }
}
