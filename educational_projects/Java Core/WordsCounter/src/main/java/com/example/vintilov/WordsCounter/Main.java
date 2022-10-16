package com.example.vintilov.WordsCounter;

public class Main {
    public static void main(String[] args) {

        String text = "Once once once upon a time a Wolf was lapping at a spring on a hillside, when, +" +
                " looking up, what  should he see but a Lamb just beginning to drink a little lower down";
        WordsCounter wordsCounter = new WordsCounter();
        wordsCounter.getWordsCount(wordsCounter.setAStringToWork(text));


    }
}
