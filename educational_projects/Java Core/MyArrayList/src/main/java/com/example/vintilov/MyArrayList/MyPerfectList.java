package com.example.vintilov.MyArrayList;

public class MyPerfectList<E> {


    private static final int DEFAULT_SIZE = 100;
    private Object[] myData = new Object[DEFAULT_SIZE];
    private int arraySize;
    private static final String EXCEPTION_MESSEGE = "Out of bounds of an array";


    private void validation(int index) {
        if (index > arraySize) {
            throw new MyPerfectException(EXCEPTION_MESSEGE);
        }
    }

    public boolean add(E data) {
        try {
            myData[arraySize++] = data;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new MyPerfectException(EXCEPTION_MESSEGE);

        }
        return true;
    }

    public boolean addWithIndex(E data, int index) {
        if (index > arraySize) {
            throw new MyPerfectException(EXCEPTION_MESSEGE);
        }
        myData[index] = data;
        arraySize++;
        return true;
    }

    public E get(int index) {
        validation(index);
        return (E) myData[index];

    }

    public int getSize() {
        return arraySize;
    }
    public E remove(int index) {
        validation(index);
        E oldValue = (E) myData[index];
        int numMoved = arraySize - index - 1;
        if (numMoved > 0)
            System.arraycopy(myData, index + 1, myData, index,
                    numMoved);
        myData[--arraySize] = null;
        return oldValue;
    }

    public boolean clear() {
        if (arraySize == 0) {
            throw new MyPerfectException("Collection is empty. There is nothing to delete");
        }

        for (int i = 0; i < arraySize; i++) {
            myData[i] = null;
            arraySize = 0;
        }
        return true;
    }

    public int indexOf(E object) {
        if (object == null) {
            for (int i = 0; i < arraySize; i++)
                if (myData[i] == null)
                    return i;
        } else {
            for (int i = 0; i < arraySize; i++)
                if (object.equals(myData[i]))
                    return i;
        }
        return -1;
    }

}
