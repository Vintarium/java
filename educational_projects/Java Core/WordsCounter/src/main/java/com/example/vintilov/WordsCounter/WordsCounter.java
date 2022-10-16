package com.example.vintilov.WordsCounter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WordsCounter {

    public List<String> setAStringToWork(String text) {
        // text = text.replaceAll("[,.]", " ");
        String[] words = text.toLowerCase().split("[ !0-9\"\\#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]+");
        List<String> arrayOfWords = new ArrayList<String>();
        arrayOfWords = Arrays.asList(words);
        Collections.sort(arrayOfWords);
        return arrayOfWords;

    }

    public int getWordsCount(List<String> list) {
        int overseer = -1;
        boolean controlNextOpiration = true;
        char firstLetterinWord;
        for (int i = 0; i < list.size(); i++) {
            char firstLetterInNextWord = list.get(i).charAt(0);

            while (i < list.size()) {
                firstLetterinWord = list.get(i).charAt(0);

                if (controlNextOpiration) {
                    System.out.println(Character.toUpperCase(firstLetterinWord) + ": ");
                    overseer++;
                }
                int calculator = 0;
                for (int j = i; j < list.size(); j++) {

                    if (list.get(i).compareTo(list.get(j)) == 0) {
                        calculator++;
                        overseer++;
                    }
                }
                i = i + calculator;
                System.out.println("  " + list.get(i - 1) + " " + calculator);

                firstLetterinWord = list.get(i - 1).charAt(0);
                if (i < list.size()) {
                    firstLetterInNextWord = list.get(i).charAt(0);
                    overseer++;
                }

                if (firstLetterinWord == firstLetterInNextWord) {
                    controlNextOpiration = false;
                } else {
                    controlNextOpiration = true;
                }
            }
        }
        if (overseer == -1){
            throw new IllegalArgumentException("You entered a numerical value. This class only works with strings");
        }
        return overseer;
    }
}

