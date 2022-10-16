package com.example.vintilov.ValidationSystem;

import java.util.regex.Pattern;

public class IntegerValidator implements Validator<Integer> {

    @Override
    public void validate(Integer integer) {
        String stringToCompareAgainstARegularExpression = String.valueOf(integer);
        if (Pattern.matches("^\\d[0]|^[^0]", stringToCompareAgainstARegularExpression)) {
                System.out.println("The number is in the valid range. Everything is fine.");
            } else {
                throw new ValidationFailedException("The number is in the invalid range, please try again");
            }
        }

    }

