package com.bankingApp.bank;

import com.bankingApp.customer.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import java.util.Random;

public class Bank {
    private String bankName;
    private double bankValue;
    private List<Customer> customers;
    Random random = new Random();

    public Bank(String name) {
        this.bankName = name;
        this.bankValue = 1200;
        this.customers = new ArrayList<>();
        String uniqueID = UUID.randomUUID().toString();
        customers.add(new Customer(uniqueID, 1200));
    }

    public double getBankValue(){
        return this.bankValue;
    }

    public void printBankData(int index){
        System.out.println(index + ".) " + this.bankName + " Value: " + this.bankValue + " (" + this.customers.size() + ") Customers Total");
    }

    public void printAllBankCustomers(){
        System.out.println(" ---- Customer list for " + this.bankName + " ---- ");
        for (Customer customer : this.customers) {
            customer.printCustomerData();
        }
    }

    public void dailyCustomerBusiness(){
        for (Customer customer : this.customers) {
            boolean deposit = random.nextDouble() < 0.6;
            if(deposit){
                double depositMuli = getRandomMultiplier(0.05, 0.12);
                double bankGained = customer.deposit(depositMuli);
                this.bankValue += bankGained;
            }else{
                double withDrawlMuli = getRandomMultiplier(0.03, 0.05);
                double bankLost = customer.withdraw(withDrawlMuli);
                this.bankValue -= bankLost;
            }
        }
        if(random.nextDouble() < 0.1){
            addNewCusomer();
            System.out.println("A new customer has been added to: " + this.bankName);
        }
    }

    public void addNewCusomer(){
        String uniqueID = UUID.randomUUID().toString();
        customers.add(new Customer(uniqueID, 1200));
    }

    private double getRandomMultiplier(double min, double max){
        return min + (max - min) * random.nextDouble();
    }

}
