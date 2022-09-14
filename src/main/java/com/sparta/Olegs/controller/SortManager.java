package com.sparta.Olegs.controller;

import com.sparta.Olegs.sorters.Sort;
import com.sparta.Olegs.utils.RandArrayBuilder;

public class SortManager {

    private static final SortManager sortManager = new SortManager();

    private SortManager() { }

    public static SortManager getSortManager() { return sortManager; }

    public int[] getSorterAndSort(int type, int size) {
        RandArrayBuilder arrBuilder = new RandArrayBuilder();
        int[] arr = arrBuilder.build(size);
        SorterFactory factory = new SorterFactory();
        Sort sorter = factory.getSorter(SorterTypes.BUBBLE);
        switch (type) {
            case 1 -> sorter = factory.getSorter(SorterTypes.BUBBLE);
            case 2 -> sorter = factory.getSorter(SorterTypes.MERGE);
            case 3 -> sorter = factory.getSorter(SorterTypes.BINARY);
        }
        return sorter.sortArray(arr);
    }
}
