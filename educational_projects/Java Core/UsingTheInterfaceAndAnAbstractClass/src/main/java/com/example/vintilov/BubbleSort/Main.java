package com.example.vintilov.BubbleSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Context context = new Context();

        int[] array = {22, 42, 65, 856, 98, 12, 23, 50, 41, 14, 5, 2, 7, 4, 1, 2, 3};

        int[] array1 = {22, 42, 65, 856, 98, 12, 23, 50, 41, 14, 5, 2, 7, 4, 1, 2, 3};

        context.setStrategy(new BubbleSorter());
        context.selectTypeSortSntrategy(array);
        System.out.println(Arrays.toString(array));


        context.setStrategy(new SelectionSorter());
        context.selectTypeSortSntrategy(array1);
        System.out.println(Arrays.toString(array1));


    }
}
