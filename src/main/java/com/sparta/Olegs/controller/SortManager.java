package com.sparta.Olegs.controller;

import com.sparta.Olegs.sorters.Sort;

public class SortManager {

    private static final SortManager sortManager = new SortManager();

    private SortManager() { }

    public static SortManager getSortManager() { return sortManager; }

    public static int[] getSorterAndSort(SorterTypes type, int[] arr) {
        SorterFactory factory = new SorterFactory();
        Sort sorter = factory.getSorter(type);
        return sorter.sortArray(arr);
    }
}
