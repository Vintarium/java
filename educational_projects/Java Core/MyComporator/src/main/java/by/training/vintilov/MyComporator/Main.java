package by.training.vintilov.MyComporator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(25);
        list.add(105);
        list.add(8);
        list.add(18);
        Collections.sort(list, new MySuperComporator());
        for (Integer element : list) {
            System.out.print(element + " ");
        }


        Integer[] array = {25, 105, 8, 18};
        Arrays.sort(array, new MySuperComporator());
        System.out.println(Arrays.toString(array));
    }
}
