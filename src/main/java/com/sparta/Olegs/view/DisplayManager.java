package com.sparta.Olegs.view;

import com.sparta.Olegs.controller.SortManager;

import java.util.Scanner;

public class DisplayManager {

    private static final DisplayManager displayManager = new DisplayManager();

    private DisplayManager() { }

    public static DisplayManager getDisplayManager() { return displayManager; }

    public void run() {
        System.out.println("==== SORT MANAGER ====");
        Scanner sc = new Scanner(System.in);
        System.out.println();
        while (true) {
            System.out.println("Choose a sorting algorithm:");
            System.out.println("1. Bubble sort");
            System.out.println("2. Merge sort");
            System.out.println("3. Binary tree sort");
            try {
                int type = sc.nextInt();
                if (type < 1 || type > 3) throw new Exception(); // not working
                System.out.println();
                System.out.println("Enter array size: ");
                int size = sc.nextInt();
                if (size < 1) throw new Exception(); // not working
                System.out.println();
                this.print(SortManager.getSortManager().getSorterAndSort(type, size));
                break;
            } catch (Exception e) {
                sc.next();
                System.out.println();
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
