package by.training.vintilov.OperationsWithHashSet;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class OperationsWithHashSet {

    private OperationsWithHashSet() {
    }


    private static <T> void validateValues(HashSet<T> one, HashSet<T> two) {
        if (one.size() == 0) {
            throw new IllegalArgumentException("The first collection passed is empty");
        } else if (two.size() == 0) {
            throw new IllegalArgumentException("The second collection passed is empty");
        }
    }


    public static <T> HashSet<T> toUnion(HashSet<T> one, HashSet<T> two) {
        OperationsWithHashSet.validateValues(one, two);
        one.addAll(two);
        return one;
    }

    public static <T> HashSet<T> toIntersection(HashSet<T> one, HashSet<T> two) {
        OperationsWithHashSet.validateValues(one, two);
        one.retainAll(two);
        return one;
    }

    public static <T> HashSet<T> toMinus(HashSet<T> one, HashSet<T> two) {
        OperationsWithHashSet.validateValues(one, two);
        one.remove(one.removeAll(two));
        return one;
    }


    public static <T> HashSet<T> toDifference(HashSet<T> one, HashSet<T> two) {
        OperationsWithHashSet.validateValues(one, two);
        Set<T> difference = new HashSet<>();
        Set<T> copyOne = new HashSet<>();
        copyOne.addAll(one);
        Set<T> copyTwo = new HashSet<>();
        copyTwo.addAll(two);
        one.remove(one.removeAll(copyTwo));
        two.remove(two.removeAll(copyOne));
        difference.addAll(one);
        difference.addAll(two);

        return (HashSet<T>) difference;
    }

}
