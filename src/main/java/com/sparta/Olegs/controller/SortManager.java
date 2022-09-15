package com.sparta.Olegs.controller;

import com.sparta.Olegs.sorters.Sort;
import com.sparta.Olegs.utils.RandArrayBuilder;

public class SortManager {

    private static final SortManager sortManager = new SortManager();

    private SortManager() { }

    public static SortManager getSortManager() { return sortManager; }

    public int[] getSorterAndSort(SorterTypes type, int[] arr) {
        SorterFactory factory = new SorterFactory();
        Sort sorter = factory.getSorter(type);
        return sorter.sortArray(arr);
    }
}
