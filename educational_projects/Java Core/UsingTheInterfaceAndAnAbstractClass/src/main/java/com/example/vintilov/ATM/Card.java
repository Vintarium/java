package com.example.vintilov.ATM;

public abstract class Card {

        private String name;
        private double balance;

        public Card(String name, double balance) {
            this.name = name;
            this.balance = balance;

        }

        public Card(String name) {
            this.name = name;
            this.balance = 0;
        }

        public abstract String getName();

        public abstract String setName(String name);

        public abstract double getBalance();

        public abstract double setBalance(double addBalance);

        public abstract double withdrawMoney(double difference);



    }

