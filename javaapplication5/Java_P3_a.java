package javaapplication5;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class InvalidDepositException extends Exception {
    public InvalidDepositException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            this.balance = 0;
        } else {
            this.balance = initialBalance;
        }
    }

    public void deposit(double amount) throws InvalidDepositException {
        if (amount <= 0) {
            throw new InvalidDepositException("Deposit must be greater than zero.");
        } else {
            balance += amount;
            System.out.println("Successfully Deposited: " + amount);
        }
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient Balance for Withdrawal.");
        } else {
            balance -= amount;
            System.out.println("Successfully Withdrawn: " + amount);
        }
    }

    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

public class Java_P3_a {

   public static void main(String[] args) {
    BankAccount account = new BankAccount(2000);

    account.displayBalance();

    try {
        account.deposit(4500);
    } catch (InvalidDepositException e) {
        System.out.println("Deposit Error: " + e.getMessage());
    }

    account.displayBalance();

    try {
        account.withdraw(50000);
    } catch (InsufficientBalanceException e) {
        System.out.println("Withdrawal Error: " + e.getMessage());
    }

    account.displayBalance();

    try {
        account.deposit(-500); // Invalid deposit (should throw exception)
    } catch (InvalidDepositException e) {
        System.out.println("Deposit Error: " + e.getMessage());
    }

    account.displayBalance();
}
}