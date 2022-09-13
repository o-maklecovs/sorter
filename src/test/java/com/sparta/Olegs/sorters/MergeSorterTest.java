package com.sparta.Olegs.sorters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MergeSorterTest {

    @Test
    void testSort() {
        int[] arrToSort = {2, 1, 3, 8, 4, 6, 7, 5};
        int[] arrToCompare = {1, 2, 3, 4, 5, 6, 7, 8};
        MergeSorter mergeSorter = new MergeSorter();
        Assertions.assertArrayEquals(arrToCompare, mergeSorter.sortArray(arrToSort));
    }

    @Test
    void testSortOneElem() {
        int[] arrToSort = {1};
        int[] arrToCompare = {1};
        MergeSorter mergeSorter = new MergeSorter();
        Assertions.assertArrayEquals(arrToCompare, mergeSorter.sortArray(arrToSort));
    }

    @Test
    void testSortEmptyArray() {
        int[] arrToSort = {};
        int[] arrToCompare = {};
        MergeSorter mergeSorter = new MergeSorter();
        Assertions.assertArrayEquals(arrToCompare, mergeSorter.sortArray(arrToSort));
    }

    @Test
    void testSortDuplicates() {
        int[] arrToSort = {1, 2, 2, 2, 4};
        int[] arrToCompare = {1, 2, 4};
        MergeSorter mergeSorter = new MergeSorter();
        Assertions.assertArrayEquals(arrToCompare, mergeSorter.sortArray(arrToSort));
    }

    @Test
    void testMergeEqualLengths() {
        int[] l = {1, 2, 3, 4};
        int[] r = {5, 6, 7, 8};
        int[] arrToCompare = {1, 2, 3, 4, 5, 6, 7, 8};
        MergeSorter mergeSorter = new MergeSorter();
        Assertions.assertArrayEquals(arrToCompare, mergeSorter.merge(l, r));
    }

    @Test
    void testMergeDifferentLengths() {
        int[] l = {5, 6};
        int[] r = {1, 2, 3, 4};
        int[] arrToCompare = {1, 2, 3, 4, 5, 6};
        MergeSorter mergeSorter = new MergeSorter();
        Assertions.assertArrayEquals(arrToCompare, mergeSorter.merge(l, r));
    }

    @Test
    void testMergeOneEmpty() {
        int[] l = {1, 2, 3};
        int[] r = {};
        int[] arrToCompare = {1, 2, 3};
        MergeSorter mergeSorter = new MergeSorter();
        Assertions.assertArrayEquals(arrToCompare, mergeSorter.merge(l, r));
    }

    @Test
    void testMergeAllEmpty() {
        int[] l = {};
        int[] r = {};
        int[] arrToCompare = {};
        MergeSorter mergeSorter = new MergeSorter();
        Assertions.assertArrayEquals(arrToCompare, mergeSorter.merge(l, r));
    }
}