package com.sparta.Olegs.sorters;

import java.util.ArrayList;

public abstract class Sort implements Sorter {

    public int[] removeDuplicates(int[] arr) {
        ArrayList<Integer> arrVals = new ArrayList<>();
        for (int j : arr) {
            if (!arrVals.contains(j))
                arrVals.add(j);
        }
        int[] result = new int[arrVals.size()];
        for (int i = 0; i < result.length; i++)
            result[i] = arrVals.get(i);
        return result;
    }
}
