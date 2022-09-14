package com.sparta.Olegs.sorters;

public class BubbleSorter extends Sort {

    // TODO: swapping optimisation
    @Override
    public int[] sortArray(int[] arrayToSort) {
        arrayToSort = removeDuplicates(arrayToSort);
        for (int i = 0; i < arrayToSort.length; i++) {
            for (int k = 0; k < arrayToSort.length - i - 1; k++) {
                if (arrayToSort[k] > arrayToSort[k + 1]) {
                    int temp = arrayToSort[k + 1];
                    arrayToSort[k + 1] = arrayToSort[k];
                    arrayToSort[k] = temp;
                }
            }
        }
        return arrayToSort;
    }
}
