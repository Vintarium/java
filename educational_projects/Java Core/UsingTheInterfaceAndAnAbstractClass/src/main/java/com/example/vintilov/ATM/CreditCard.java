package com.example.vintilov.ATM;

public class CreditCard extends Card {
    private String nameUserCreditCard;
    private double balanceCreditCard;
    private Atm atm;


    public CreditCard(String name, double balance) {
        super(name, balance);
        nameUserCreditCard = name;
        balanceCreditCard = balance;

    }

    public CreditCard(String name) {
        super(name);
        nameUserCreditCard = name;
    }


    @Override
    public double setBalance(double addBalance) {

        balanceCreditCard += addBalance;
        return balanceCreditCard;
    }

    @Override
    public double getBalance() {
        return this.balanceCreditCard;
    }

    @Override
    public double withdrawMoney(double difference) {

        balanceCreditCard -= difference;
        return balanceCreditCard;

    }


    @Override
    public String getName() {
        return nameUserCreditCard;
    }

    @Override
    public String setName(String name) {
        this.nameUserCreditCard = name;
        return nameUserCreditCard;
    }
}
