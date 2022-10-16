package by.training.vintilov.OperationsWithHashSet;

import by.training.vintilov.OperationsWithHashSet.OperationsWithHashSet;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class OperationsWithHashSetTest {
    private final static HashSet<String> setOne = new HashSet<>();
    private final static HashSet<String> setTwo = new HashSet<>();


    @org.junit.Test
    public void toUnion() {
        /*Given*/
        setOne.add("Hello");
        setOne.add("My");

        setTwo.add("My");
        setTwo.add("Friend");

        Set<String> expected = new HashSet<>();
        expected.add("Hello");
        expected.add("My");
        expected.add("Friend");
        /*When*/
        Set actual = OperationsWithHashSet.toUnion(setOne, setTwo);
        /*Then*/
        assertThat(expected, is(actual));
        setOne.clear();
        setTwo.clear();

    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void toUnionNegative() {
        OperationsWithHashSet.toUnion(setOne, setTwo);
    }

    @org.junit.Test
    public void toIntersection() {
        /*Given*/
        setOne.add("Hello");
        setOne.add("My");

        setTwo.add("My");
        setTwo.add("Friend");

        Set<String> expected = new HashSet<>();
        expected.add("My");
        /*When*/
        Set actual = OperationsWithHashSet.toIntersection(setOne, setTwo);
        /*Then*/
        assertThat(expected, is(actual));
        setOne.clear();
        setTwo.clear();
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void toIntersectionNegative() {
        OperationsWithHashSet.toIntersection(setOne, setTwo);
    }


    @org.junit.Test
    public void toMinus() {
        /*Given*/
        setOne.add("Hello");
        setOne.add("My");

        setTwo.add("My");
        setTwo.add("Friend");

        Set<String> expected = new HashSet<>();
        expected.add("Hello");
        /*When*/
        Set actual = OperationsWithHashSet.toMinus(setOne, setTwo);
        /*Then*/
        assertThat(expected, is(actual));
        setOne.clear();
        setTwo.clear();
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void toMinusNegative() {
        OperationsWithHashSet.toMinus(setOne, setTwo);
    }

    @org.junit.Test
    public void toDifference() {
        /*Given*/
        setOne.add("Hello");
        setOne.add("My");

        setTwo.add("My");
        setTwo.add("Friend");


        Set<String> expected = new HashSet<>();
        expected.add("Hello");
        expected.add("Friend");
        /*When*/
        Set actual = OperationsWithHashSet.toDifference(setOne, setTwo);
        /*Then*/
        assertThat(expected, is(actual));
        setOne.clear();
        setTwo.clear();
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void toDifferenceNegative() {
        OperationsWithHashSet.toDifference(setOne, setTwo);
    }

}