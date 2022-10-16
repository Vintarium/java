package com.example.vintilov.MyArrayList;

public class Main {
    public static void main(String[] args) {
        MyPerfectList<Integer> str = new MyPerfectList<Integer>();
        str.add(1);
        str.add(2);
        str.add(3);

        System.out.println(str.getSize());

    }
}
