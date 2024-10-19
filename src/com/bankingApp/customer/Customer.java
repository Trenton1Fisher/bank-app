package com.bankingApp.customer;

public class Customer {
    private String accountId;
    private double totalNetWorth;

    public Customer(String bankProvidedId, int initialDeposit) {
        this.accountId = bankProvidedId;
        this.totalNetWorth = initialDeposit;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public double getTotalNetWorth() {
        return this.totalNetWorth;
    }

    public double deposit(double multiplier) {
        double pendingDeposit;
        if(this.totalNetWorth > 0){
            pendingDeposit =  this.totalNetWorth + (this.totalNetWorth * multiplier);
            this.totalNetWorth = pendingDeposit;
            return pendingDeposit;
        }else{
            this.totalNetWorth = 1200;
            return 1200;
        }
    }

    public double withdraw(double multiplier){
        double pendingWithdrawl = this.totalNetWorth - (this.totalNetWorth * multiplier);
        if(pendingWithdrawl > 0){
            this.totalNetWorth = pendingWithdrawl;
            return pendingWithdrawl;
        }else{
            this.totalNetWorth = 0;
            return 0;
        }
    }

    public void printCustomerData(){
        System.out.println("Customer Id: " + this.accountId + " total amount saved: " + this.totalNetWorth);
    }


}