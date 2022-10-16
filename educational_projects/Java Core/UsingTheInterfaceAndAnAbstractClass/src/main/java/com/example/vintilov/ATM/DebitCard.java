package com.example.vintilov.ATM;

public class DebitCard extends Card {
    private String nameUserDebitCard;
    private double balanceDebitCard;
    private Atm atm;


    public DebitCard(String name, double balance) {
        super(name, balance);
        nameUserDebitCard = name;
        balanceDebitCard = balance;
    }

    public DebitCard(String name) {
        super(name);
        nameUserDebitCard = name;
    }

    @Override
    public double withdrawMoney(double difference) {
        if (difference > balanceDebitCard) {
            System.out.println("Недостаточно средств на счету");
        } else {
            balanceDebitCard -= difference;

        }
        return this.balanceDebitCard;
    }


    @Override
    public String getName() {
        return this.nameUserDebitCard;
    }

    @Override
    public String setName(String name) {
        this.nameUserDebitCard = name;
        return nameUserDebitCard;
    }

    @Override
    public double getBalance() {
        return this.balanceDebitCard;
    }

    @Override
    public double setBalance(double addBalance) {
        this.balanceDebitCard += addBalance;
        return this.balanceDebitCard;
    }


}
