package com.example.vintilov.ATM;

public final class Atm {
    private Card card;

    Atm(Card card) {
        this.card = card;
    }


    public double withdrawingMoneyFromTheCard(double withdrawNumber) {
        card.withdrawMoney(withdrawNumber);
        return card.getBalance();
    }


    public double setMoneyOnTheCard(double addNumber) {
        card.setBalance(addNumber);
        return card.getBalance();
    }
}
