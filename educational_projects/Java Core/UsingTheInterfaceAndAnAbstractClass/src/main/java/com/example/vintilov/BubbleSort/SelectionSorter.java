package com.example.vintilov.BubbleSort;

public class SelectionSorter implements Sorting {
    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int index = i;
            int smallerNumbers = array[i];

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < smallerNumbers) {
                    index = j;
                    smallerNumbers = array[j];
                }
            }
            array[index] = array[i];
            array[i] = smallerNumbers;
        }
        return array;
    }

}
