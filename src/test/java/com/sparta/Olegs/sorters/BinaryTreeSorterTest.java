package com.sparta.Olegs.sorters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinaryTreeSorterTest {
    @Test
    void testBinaryTreeSorter() {
        int[] arrToSort = {3, 1, 4, 5, 2};
        int[] arrToCompare = {1, 2, 3, 4, 5};
        BinaryTreeSorter binaryTreeSorter = new BinaryTreeSorter();
        Assertions.assertArrayEquals(arrToCompare, binaryTreeSorter.sortArray(arrToSort));
    }

    @Test
    void testBinaryTreeSorterDuplicates() {
        int[] arrToSort = {3, 1, 4, 5, 2, 1, 2};
        int[] arrToCompare = {1, 2, 3, 4, 5};
        BinaryTreeSorter binaryTreeSorter = new BinaryTreeSorter();
        Assertions.assertArrayEquals(arrToCompare, binaryTreeSorter.sortArray(arrToSort));
    }

    @Test
    void testBinaryTreeSorterOne() {
        int[] arrToSort = {1};
        int[] arrToCompare = {1};
        BinaryTreeSorter binaryTreeSorter = new BinaryTreeSorter();
        Assertions.assertArrayEquals(arrToCompare, binaryTreeSorter.sortArray(arrToSort));
    }

    @Test
    void testBinaryTreeSorterEmpty() {
        int[] arrToSort = {};
        int[] arrToCompare = {};
        BinaryTreeSorter binaryTreeSorter = new BinaryTreeSorter();
        Assertions.assertArrayEquals(arrToCompare, binaryTreeSorter.sortArray(arrToSort));
    }
}