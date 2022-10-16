package com.example.vintilov.MyArrayList;

import org.junit.Assert;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class MyPerfectListTest {
    private MyPerfectList<String> list = new MyPerfectList<String>();


    @Test
    public void add() {
        /*Given*/
        list.add("one");
        list.add("two");
        list.add("three");
        String[] expected = new String[list.getSize()];
        expected[0] = "one";
        expected[1] = "two";
        expected[2] = "three";
        /*When*/
        String[] actual = new String[list.getSize()];
        actual[0] = list.get(0);
        actual[1] = list.get(1);
        actual[2] = list.get(2);
        /*Then*/
        assertThat(expected, is(actual));
        list.clear();
    }

    @Test(expected = MyPerfectException.class)
    public void addNegative() {
        MyPerfectList<String> list1 = new MyPerfectList<String>();
        for (int i = 0; i < 101; i++) {
            list1.add("hello");
        }
        list.clear();

    }

    @Test
    public void addWithIndex() {
        /*Given*/
        list.addWithIndex("two", 0);
        list.addWithIndex("three", 1);
        list.addWithIndex("one", 2);
        String[] expected = new String[list.getSize()];
        expected[0] = "two";
        expected[1] = "three";
        expected[2] = "one";
        /*When*/
        String[] actual = new String[list.getSize()];
        actual[0] = list.get(0);
        actual[1] = list.get(1);
        actual[2] = list.get(2);
        /*Then*/
        assertThat(expected, is(actual));
        list.clear();
    }

    @Test(expected = MyPerfectException.class)
    public void addWithIndexNegative() {
        for (int i = 0; i < 101; i++) {
            list.add("hello");
        }
        list.clear();
    }


    @Test
    public void get() {
        /*Given*/
        list.add("one");
        list.add("two");
        list.add("three");
        String expected = "three";
        /*When*/
        String actual = list.get(2);
        /*Then*/
        Assert.assertEquals(expected, actual);
        list.clear();
    }

    @Test(expected = MyPerfectException.class)
    public void getNegative() {
        //MyPerfectList<String> list = new MyPerfectList<String>();
        list.add("hello");
        list.add("My");
        list.add("Friend");
        list.get(5);

        list.clear();
    }

    @Test
    public void getSize() {
        /*Given*/
        list.add("one");
        list.add("two");
        list.add("three");
        int expected = 3;
        /*When*/
        int actual = list.getSize();
        /*Then*/
        Assert.assertEquals(expected, actual);
        list.clear();
    }

    @Test
    public void getSizeNegative() {

    }

    @Test
    public void remove() {
        /*Given*/
        list.add("hello");
        list.add("world");
        list.remove(0);
        String expected = "world";
        /*When*/
        String actual = list.get(0);
        /*Then*/
        Assert.assertEquals(expected, actual);
        list.clear();
    }

    @Test(expected = MyPerfectException.class)
    public void removeNegative() {
        list.add("one");
        list.remove(2);
        list.clear();
    }

    @Test
    public void clear() {
        /*Given*/
        list.add("Manson");
        list.add("Korn");
        list.add("Rammstein");
        int expected = 3;
        /*When*/
        int actual = list.getSize();
        /*Then*/
        Assert.assertEquals(expected, actual);
        list.clear();
    }

    @Test(expected = MyPerfectException.class)
    public void clearNegative() {
        list.clear();
    }

    @Test
    public void indexOf() {
        /*Given*/
        list.add("hohoho");
        list.add("gogogo");
        list.add("zozozo");
        list.add("bobobo");
        list.add("dododo");
        list.add("momomo");
        int expected = 2;
        /*When*/
        int actual = list.indexOf("zozozo");
        /*Then*/
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void indexOfNegative() {
        /*Given*/
        int expected = -1;
        /*When*/
        int actual = list.indexOf("What a strange test");
        /*Then*/
        Assert.assertEquals(expected, actual);


    }

}