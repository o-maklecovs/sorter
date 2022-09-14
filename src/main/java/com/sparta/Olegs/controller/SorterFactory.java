package com.sparta.Olegs.controller;

import com.sparta.Olegs.sorters.BubbleSorter;
import com.sparta.Olegs.sorters.MergeSorter;
import com.sparta.Olegs.sorters.Sort;

public class SorterFactory {

    public Sort getSorter(SorterTypes type) {
        return switch (type) {
            case BUBBLE -> new BubbleSorter();
            case MERGE -> new MergeSorter();
            default -> null;
        };
    }
}
