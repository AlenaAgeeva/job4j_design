package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    private int[] data;
    private int index;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean res = data.length > index && data[index] % 2 == 0;
        while (!res && data.length - 1 > index) {
            index++;
            res = data[index] % 2 == 0;
        }
        return res;
    }

    public boolean check() {
        return data.length > index && data[index] % 2 == 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[index++];
    }
}

