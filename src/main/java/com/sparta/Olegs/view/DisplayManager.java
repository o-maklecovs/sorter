package com.sparta.Olegs.view;

import com.sparta.Olegs.controller.SortManager;
import com.sparta.Olegs.controller.SorterTypes;
import com.sparta.Olegs.utils.RandArrayBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class DisplayManager {

    private static final Logger logger = LogManager.getLogger();

    private static final DisplayManager displayManager = new DisplayManager();

    private DisplayManager() { }

    public static DisplayManager getDisplayManager() { return displayManager; }

    public void run() {
        System.out.println("==== SORT MANAGER ====");
        System.out.println();
        while (true) {
            System.out.println("Choose a sorting algorithm:");
            System.out.println("1. Bubble sort");
            System.out.println("2. Merge sort");
            System.out.println("3. Binary tree sort");
            try {
                Scanner sc = new Scanner(System.in);
                int type = sc.nextInt();
                if (type < 1 || type > 3) throw new Exception("Invalid input range");
                System.out.println();
                System.out.println("Enter array size: ");
                int size = sc.nextInt();
                if (size < 1) throw new Exception("Invalid input range");
                System.out.println();
                RandArrayBuilder builder = new RandArrayBuilder();
                int[] arr = builder.build(size);
                this.print(arr);
                System.out.println();
                this.handleSorterChoice(type, arr);
                System.out.println();
                // print first time
                System.out.println();
                System.out.println("Do you want to compare to another algorithm? (y/n)");
                String answer = sc.nextLine();
                if (answer.equalsIgnoreCase("y")) {
                    System.out.println("Choose a sorting algorithm:");
                    if (type != 1) System.out.println("1. Bubble sort");
                    if (type != 2) System.out.println("2. Merge sort");
                    if (type != 3) System.out.println("3. Binary tree sort");
                    int typeToCompare = sc.nextInt();
                    if (typeToCompare < 1 || typeToCompare > 3) throw new Exception("Invalid input range");
                    System.out.println();
                    this.handleSorterChoice(typeToCompare, arr);
                    System.out.println();
                    // print first and second time
                } else if (answer.equalsIgnoreCase("n")) break;
                else throw new Exception("Invalid input range");
                break;
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                System.out.println();
                System.out.println("Invalid input type");
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

    public void handleSorterChoice(int type, int[] arr) {
        switch (type) {
            case 1 -> {
                System.out.println("Sorting with Bubble sort...");
                System.out.println();
                this.print(SortManager.getSortManager().getSorterAndSort(SorterTypes.BUBBLE, arr));
            }
            case 2 -> {
                System.out.println("Sorting with Merge sort...");
                System.out.println();
                this.print(SortManager.getSortManager().getSorterAndSort(SorterTypes.MERGE, arr));
            }
            case 3 -> {
                System.out.println("Sorting with Binary Tree sort...");
                System.out.println();
                this.print(SortManager.getSortManager().getSorterAndSort(SorterTypes.BINARY, arr));
            }
        }
    }
}
