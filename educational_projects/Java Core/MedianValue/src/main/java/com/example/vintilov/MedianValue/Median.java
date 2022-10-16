package com.example.vintilov.MedianValue;

public final class Median {

    public static float findingTheMedianInIntegers(int[] arraysInteger) {
        int variableForSortingTheArray;
        for (int i = 0; i < arraysInteger.length; i++) {
            for (int j = 0; j < arraysInteger.length - 1; j++) {
                if (arraysInteger[j] > arraysInteger[j + 1]) {
                    variableForSortingTheArray = arraysInteger[j];
                    arraysInteger[j] = arraysInteger[j + 1];
                    arraysInteger[j + 1] = variableForSortingTheArray;
                }
            }
        }

        if (arraysInteger.length % 2 == 0) {
            return (arraysInteger[arraysInteger.length / 2] + arraysInteger[arraysInteger.length / 2 - 1]) / 2f;
        }
        return arraysInteger[arraysInteger.length / 2];
    }


    public static double findingTheMedianInDoubles(double[] arraysDouble) {
        double variableForSortingTheArray;
        for (int i = 0; i < arraysDouble.length; i++) {
            for (int j = 0; j < arraysDouble.length - 1; j++) {
                if (arraysDouble[j] > arraysDouble[j + 1]) {
                    variableForSortingTheArray = arraysDouble[j];
                    arraysDouble[j] = arraysDouble[j + 1];
                    arraysDouble[j + 1] = variableForSortingTheArray;
                }
            }
        }

        if (arraysDouble.length % 2 == 0) {
            return (arraysDouble[arraysDouble.length / 2] + arraysDouble[arraysDouble.length / 2 - 1]) / 2;
        }
        return arraysDouble[arraysDouble.length / 2];
    }

}
