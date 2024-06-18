package ru.job4j.algo.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MergeTest {

    @Test
    void whenSortedThenOk1() {
        int[] array = {10, 4, 6, 4, 8, -13, 2, 3};
        assertThat(Merge.mergesort(array)).containsExactly(-13, 2, 3, 4, 4, 6, 8, 10);
    }

    @Test
    void whenSortedThenOk2() {
        int[] array = {10, 4, 6, 4, 0, 8, -13, 2, 3};
        assertThat(Merge.mergesort(array)).containsExactly(-13, 0, 2, 3, 4, 4, 6, 8, 10);
    }

    @Test
    void whenSortedThenOk3() {
        int[] array = {-10, 4, 6, 4, 0, 8, -13, 2, -3};
        assertThat(Merge.mergesort(array)).containsExactly(-13, -10, -3, 0, 2, 4, 4, 6, 8);
    }
}