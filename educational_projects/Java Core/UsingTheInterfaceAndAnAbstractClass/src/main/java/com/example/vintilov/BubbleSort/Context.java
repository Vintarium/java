package com.example.vintilov.BubbleSort;

public class Context {
    private Sorting sorting;


    public void setStrategy(Sorting sorting) {
        this.sorting = sorting;
    }

    public int[] selectTypeSortSntrategy(int[] arr) {
        return this.sorting.sort(arr);
    }

}
