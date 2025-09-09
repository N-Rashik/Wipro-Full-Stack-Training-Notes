package com.wipro;

public class InnerClass {

    private String accountHolder;
    private double balance;

    // Constructor
    public InnerClass(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Member Inner Class
    public class Transaction {

        public void deposit(double amount) {
            balance += amount;
            System.out.println(amount + " Rs. is Deposited and now the balance is: " + balance);
        }

        public void withdraw(double amount) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawal amount is " + amount + " and now the balance is: " + balance);
            } else {
                System.out.println("Insufficient balance. Cannot withdraw " + amount);
            }
        }
    }

    // Method to display balance
    public void showBalance() {
        System.out.println("Account Holder: " + accountHolder + " | Balance in your account: " + balance);
    }

    // Main method
    public static void main(String[] args) {
        InnerClass acc = new InnerClass("Rashik", 5000);
        InnerClass.Transaction t = acc.new Transaction();

        System.out.println("The current Balance in your account is:");
        acc.showBalance();

        t.deposit(2000);
        acc.showBalance();

        t.withdraw(1000);
        acc.showBalance();
    }
}
