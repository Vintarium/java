package com.example.vintilov.ValidationSystem;


import java.util.regex.Pattern;

public class StringValidator implements Validator<String> {
    @Override
    public void validate(String string)  {
        char firstLetterOfEnteredLine = string.charAt(0);
        String stringToCompare = Character.toString(firstLetterOfEnteredLine);
        if (Pattern.matches("^[A-Z]", stringToCompare)) {
            System.out.println("The string is ok");
        } else {
            throw new ValidationFailedException("Invalid string format");
        }

    }
}









