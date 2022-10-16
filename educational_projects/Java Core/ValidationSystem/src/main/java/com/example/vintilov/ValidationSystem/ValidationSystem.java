package com.example.vintilov.ValidationSystem;


public final class ValidationSystem {

    private ValidationSystem() {
    }
    public static <T> void validate(T object) {
        if (object instanceof Integer) {
            new IntegerValidator().validate((Integer) object);
        } else if (object instanceof String) {
            new StringValidator().validate((String) object);
        }
    }

}




