package com.sparta.Olegs.controller;

import com.sparta.Olegs.sorters.Sort;
import com.sparta.Olegs.view.DisplayManager;
import com.sparta.Olegs.utils.RandArrayBuilder;

public class SortManager {

    private static final SortManager sortManager = new SortManager();

    private SortManager() { }

    public static SortManager getSortManager() { return sortManager; }

    public Sort getSorter(SorterTypes type) {
        SorterFactory factory = new SorterFactory();
        return factory.getSorter(type);
    }

    public int[] buildArray(int size) {
        RandArrayBuilder builder = new RandArrayBuilder();
        return builder.build(size);
    }

    public void run() {
        DisplayManager view = new DisplayManager();

        int type = view.chooseAlgorithm();
        int size = view.chooseSize();

        Sort sorter = this.matchType(type);
        String typeName = this.matchName(type);

        int[] original = this.buildArray(size);

        long startFirst = System.nanoTime();
        int[] sorted = sorter.sortArray(original);
        long timeFirst = System.nanoTime() - startFirst;

        view.printSortResult(original, sorted, timeFirst, typeName);

        boolean choice = view.chooseToCompare();
        if (choice) {
            int typeSecond = view.chooseAlgorithm();
            Sort sorterSecond = this.matchType(typeSecond);
            String typeNameSecond = this.matchName(typeSecond);

            long startSecond = System.nanoTime();
            int[] sortedSecond = sorterSecond.sortArray(original);
            long timeSecond = System.nanoTime() - startSecond;

            view.printSortResult(original, sortedSecond, timeSecond, typeNameSecond);

            if (timeFirst > timeSecond)
                view.printComparisonResult(timeFirst - timeSecond);
            else
                view.printComparisonResult(timeSecond - timeFirst);
        }
    }

    public Sort matchType(int type) {
        switch (type) {
            case 1 -> {
                return this.getSorter(SorterTypes.BUBBLE);
            }
            case 2 -> {
                return this.getSorter(SorterTypes.MERGE);
            }
            case 3 -> {
                return this.getSorter(SorterTypes.BINARY);
            }
        }
        return this.getSorter(SorterTypes.BUBBLE);
    }

    public String matchName(int type) {
        switch (type) {
            case 1 -> {
                return "Bubble";
            }
            case 2 -> {
                return "Merge";
            }
            case 3 -> {
                return "Binary Tree";
            }
        }
        return "Bubble";
    }
}
