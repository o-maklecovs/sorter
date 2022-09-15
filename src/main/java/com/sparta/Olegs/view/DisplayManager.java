package com.sparta.Olegs.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class DisplayManager {

    private static final Logger logger = LogManager.getLogger();

    public int chooseAlgorithm() {
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

                return type;
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                System.out.println();
            }
        }
    }

    public int chooseSize() {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);

                System.out.println("Enter array size: ");
                int size = sc.nextInt();
                if (size < 1) throw new Exception("Invalid input range");

                return size;
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                System.out.println();
            }
        }
    }

    public void printSortResult(int[] original, int[] sorted, long time, String type) {
        System.out.println();
        System.out.println("Original:");
        this.printArr(original);
        System.out.println();

        System.out.println("Sorted using " + type + " sort");
        this.printArr(sorted);
        System.out.println();

        System.out.println("Execution time: " + time / 1000000 + " ms");
    }

    public boolean chooseToCompare() {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);

                System.out.println("Do you wish to compare to another algorithm? (y/n)");
                String answer = sc.next();
                if (answer.equalsIgnoreCase("y")) return true;
                else if (answer.equalsIgnoreCase("n")) return false;
                else throw new Exception("Invalid input range");
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                System.out.println();
            }
        }
    }

    public void printComparisonResult(long result) {
        System.out.println("Difference: " + result / 1000000 + " ms");
    }

    public void printArr(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (i == 0)
                System.out.print("[" + a[i] + ", ");
            else if (i == a.length - 1)
                System.out.print(a[i] + "]");
            else
                System.out.print(a[i] + ", ");
        }
        System.out.println();
    }
}
