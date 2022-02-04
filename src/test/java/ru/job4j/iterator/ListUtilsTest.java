package ru.job4j.iterator;

import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;

public class ListUtilsTest {
    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertEquals(input, Arrays.asList(1, 2, 3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertEquals(input, Arrays.asList(0, 1, 2, 3));
    }

    @Test
    public void whenRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        ListUtils.removeIf(input, x -> x > 2);
        assertEquals(input, Arrays.asList(0, 1, 2));
    }

    @Test
    public void whenReplaceIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        ListUtils.replaceIf(input, x -> x > 2, 7);
        assertEquals(input, Arrays.asList(0, 1, 2, 7, 7));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        List<Integer> inputSecond = new ArrayList<>(Arrays.asList(2, 3, 4));
        ListUtils.removeAll(input, inputSecond);
        assertEquals(input, Arrays.asList(0, 1));
    }
}