package com.sparta.Olegs.view;

import com.sparta.Olegs.controller.SortManager;
import com.sparta.Olegs.controller.SorterTypes;
import com.sparta.Olegs.utils.RandArrayBuilder;

import java.util.Scanner;

public class DisplayManager {

    private static final DisplayManager displayManager = new DisplayManager();

    private DisplayManager() { }

    public static DisplayManager getDisplayManager() { return displayManager; }

    // TODO add exception handling
    public void run() {
        System.out.println("==== SORT MANAGER ====");
        Scanner sc = new Scanner(System.in);
        System.out.println();
        while (true) {
            System.out.println("Choose a sorting algorithm:");
            System.out.println("1. Bubble sort");
            System.out.println("2. Merge sort");
            System.out.println("3. Binary tree sort");
            if (sc.hasNextInt()) {
                int algo = sc.nextInt();
                System.out.println();
                System.out.println("Enter array size: ");
                if (sc.hasNextInt()) {
                    int size = sc.nextInt();
                    RandArrayBuilder arrBuilder = new RandArrayBuilder();
                    int[] arr = arrBuilder.build(size);
                    System.out.println();
                    switch (algo) {
                        case 1 -> print(SortManager.getSortManager().getSorterAndSort(SorterTypes.BUBBLE, arr));
                        case 2 -> print(SortManager.getSortManager().getSorterAndSort(SorterTypes.MERGE, arr));
                        case 3 -> print(SortManager.getSortManager().getSorterAndSort(SorterTypes.BINARY, arr));
                    }
                    break;
                } else {
                    sc.next();
                    System.out.println("Invalid input");
                    System.out.println();
                }
            } else {
                sc.next();
                System.out.println("Invalid input");
                System.out.println();
            }
        }
    }

    public void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (i == 0)
                System.out.print("[" + a[i] + ", ");
            else if (i == a.length - 1)
                System.out.print(a[i] + "]");
            else
                System.out.print(a[i] + ", ");
        }
    }
}
