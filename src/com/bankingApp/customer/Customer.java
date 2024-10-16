package customer;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String accountId;
    private int totalNetWorth;
    private List<String> transactionHistory;

    public Customer(String bankProvidedId, int initialDeposit) {
        this.accountId = bankProvidedId;
        this.totalNetWorth = initialDeposit;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Initial deposit: " + initialDeposit);
    }

    public String getAccountId() {
        return this.accountId;
    }

    public int getTotalNetWorth() {
        return this.totalNetWorth;
    }

    public void deposit(int depositValue) {
        if (depositValue > 0) {
            this.totalNetWorth += depositValue;
            transactionHistory.add("Deposited: " + depositValue);
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }

    public void withdraw(int withdrawalValue) {
        if (withdrawalValue > 0 && withdrawalValue <= totalNetWorth) {
            this.totalNetWorth -= withdrawalValue;
            transactionHistory.add("Withdrew: " + withdrawalValue);
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }

    public List<String> getTransactionHistory() {
        return this.transactionHistory;
    }
}