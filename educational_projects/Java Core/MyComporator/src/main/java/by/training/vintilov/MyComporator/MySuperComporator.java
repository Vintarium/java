package by.training.vintilov.MyComporator;

import java.util.Comparator;

public class MySuperComporator implements Comparator {
    private static final int ONE_NUMBER = 1;
    private static final int TWO_NUMBERS = 2;
    private static final int THREE_NUMBERS = 3;
    @Override
    public int compare(Object o1, Object o2) throws IllegalArgumentException {

        int firstArgument = 0;
        int secondArgument = 0;


        String stringValueOfTheArgumentO1 = Integer.toString((Integer) o1);
        String stringValueOfTheArgumentO2 = Integer.toString((Integer) o2);

        char[] numbersInArgumentO1 = stringValueOfTheArgumentO1.toCharArray();
        char[] numbersInArgumentO2 = stringValueOfTheArgumentO2.toCharArray();


        if (numbersInArgumentO1.length == ONE_NUMBER) {
            firstArgument = Character.getNumericValue(numbersInArgumentO1[0]);
        }


        if (numbersInArgumentO1.length == TWO_NUMBERS) {
            int firstNumber = Character.getNumericValue(numbersInArgumentO1[0]);
            int secondNumber = Character.getNumericValue(numbersInArgumentO1[1]);
            firstArgument = firstNumber + secondNumber;
        }

        if (numbersInArgumentO1.length == THREE_NUMBERS) {
            int firstNumber = Character.getNumericValue(numbersInArgumentO1[0]);
            int secondNumber = Character.getNumericValue(numbersInArgumentO1[1]);
            int thirdNumber = Character.getNumericValue(numbersInArgumentO1[2]);
            firstArgument = firstNumber + secondNumber + thirdNumber;
        }


        if (numbersInArgumentO2.length == ONE_NUMBER) {
            secondArgument = Character.getNumericValue(numbersInArgumentO2[0]);
        }


        if (numbersInArgumentO2.length == TWO_NUMBERS) {
            int firstNumber = Character.getNumericValue(numbersInArgumentO2[0]);
            int secondNumber = Character.getNumericValue(numbersInArgumentO2[1]);
            secondArgument = secondNumber + firstNumber;

        }


        if (numbersInArgumentO2.length == THREE_NUMBERS) {
            int firstNumber = Character.getNumericValue(numbersInArgumentO2[0]);
            int secondNumber = Character.getNumericValue(numbersInArgumentO2[1]);
            int thirdNumber = Character.getNumericValue(numbersInArgumentO2[2]);
            secondArgument = secondNumber + firstNumber + thirdNumber;

        }


        if (firstArgument > secondArgument) {
            return 1;
        } else if (firstArgument < secondArgument) {

            return -1;
        } else

            return 0;
    }
}
