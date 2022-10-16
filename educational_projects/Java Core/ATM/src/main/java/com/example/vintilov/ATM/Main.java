package com.example.vintilov.ATM;


public class Main {
    public static void main(String[] args) {
        Card debit = new DebitCard("Alex", 5000);

        Atm atm = new Atm(debit);
        atm.withdrawingMoneyFromTheCard(6000);
        System.out.println(debit.getBalance());


        Card credit = new CreditCard("Nona", 5000);
        Atm atm1 = new Atm(credit);

        System.out.println(atm1.setMoneyOnTheCard(5000));
        System.out.println(credit.getBalance());


    }
}
