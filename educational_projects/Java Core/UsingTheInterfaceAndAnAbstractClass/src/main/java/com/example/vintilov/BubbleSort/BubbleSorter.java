package com.example.vintilov.BubbleSort;

public class BubbleSorter implements  Sorting {
    public int [] sort(int[] arr) {
        int variableForSortingTheArray;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    variableForSortingTheArray = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = variableForSortingTheArray;
                }
            }
        }
        return arr;
    }
}
