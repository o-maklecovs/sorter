package com.sparta.Olegs.sorters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BubbleSorterTest {
    @Test
    void testBubbleSorter() {
        int[] arrToSort = {3, 2, 5, 1, 4};
        int[] arrToCompare = {1, 2, 3, 4, 5};
        BubbleSorter bubbleSorter = new BubbleSorter();
        Assertions.assertArrayEquals(arrToCompare, bubbleSorter.sortArray(arrToSort));
    }

    @Test
    void testBubblerSorterOne() {
        int[] arrToSort = {1};
        int[] arrToCompare = {1};
        BubbleSorter bubbleSorter = new BubbleSorter();
        Assertions.assertArrayEquals(arrToCompare, bubbleSorter.sortArray(arrToSort));
    }

    @Test
    void testBubbleSorterEmpty() {
        int[] arrToSort = {};
        int[] arrToCompare = {};
        BubbleSorter bubbleSorter = new BubbleSorter();
        Assertions.assertArrayEquals(arrToCompare, bubbleSorter.sortArray(arrToSort));
    }
}