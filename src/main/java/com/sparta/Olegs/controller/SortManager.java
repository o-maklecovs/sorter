package com.sparta.Olegs.controller;

import com.sparta.Olegs.sorters.BubbleSorter;
import com.sparta.Olegs.sorters.MergeSorter;
import com.sparta.Olegs.sorters.Sort;

public class SortManager {

    private static final SortManager sortManager = new SortManager();

    private SortManager() { }

    public static SortManager getSortManager() { return sortManager; }

    public Sort getSorter(SorterTypes type) {
        return switch (type) {
            case BUBBLE -> new BubbleSorter();
            case MERGE -> new MergeSorter();
            default -> null;
        };
    }
}
