package by.training.vintilov.MyComporator;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MySuperComporatorTest {
    private final static MySuperComporator comporator = new MySuperComporator();
    private final static Integer[] array = {10, 300, 11, 67, 9};

    @Test
    public void compare() {
        /*Given*/
        Integer[] expected = {10, 11, 300, 9, 67};
        /*When*/
        Arrays.sort(array, new MySuperComporator());
        Integer[] actual = new Integer[array.length];
        System.arraycopy(array, 0, actual, 0, array.length);
        /*Then*/
        Assert.assertArrayEquals(expected, actual);

    }


}