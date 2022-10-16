package com.example.vintilov.ATM;

public class Verificator {
    private static double balance;

    public static double verify(String[] arr) {
        if (arr.length != 2) {
            throw new ArrayIndexOutOfBoundsException("Too many or too few values. Please try again.");
        }

        try {
            String name = arr[0];
        } catch (NullPointerException e) {
            System.out.println(e + "you entered an empty line. Please try again\n");
        }

        try {
             balance = Double.parseDouble(arr[1]);
        } catch (IllegalArgumentException e) {
            System.out.println(e + " - wrong format. Please try to enter the number again\n");
        }


        return balance;
    }
}
