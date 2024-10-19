package com.bankingApp.owner;


import java.util.List;
import java.util.ArrayList;

import com.bankingApp.bank.Bank;

public class Owner {
    private double totalNetworth;
    private List<Bank> ownedBanks;

    public Owner(){
        this.totalNetworth = 1200;
        this.ownedBanks = new ArrayList<>();
        this.ownedBanks.add(new Bank("Capital One"));
    }

    public void viewBanks(){
        int i = 1;
        for(Bank bank: this.ownedBanks){
            bank.printBankData(i);
            i++;
        }
    }

    public double getOwnerNetworth(){
        return this.totalNetworth;
    }

    public boolean goToNextDay(){
        double newNetworth = 0;
        for(Bank bank: this.ownedBanks){
            bank.dailyCustomerBusiness();
            newNetworth += bank.getBankValue();
        }
        this.totalNetworth = newNetworth;
        if (this.totalNetworth >= (this.ownedBanks.size() * 20000)){
            return true;
        }
        return false;
    }

    public void makeNewBank(String name){
        this.ownedBanks.add(new Bank(name));
        this.totalNetworth += 1200;
    }

}
