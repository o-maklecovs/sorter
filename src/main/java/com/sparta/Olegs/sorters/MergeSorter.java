package com.sparta.Olegs.sorters;

public class MergeSorter implements Sorter {

    public int[] sortArray(int[] arrayToSort) {
        if (arrayToSort.length < 2)
            return arrayToSort;
        int mid = arrayToSort.length / 2;
        int[] l = new int[mid];
        int[] r = new int[arrayToSort.length - mid];
        for (int i = 0; i < mid; i++)
            l[i] = arrayToSort[i];
        for (int i = mid; i < arrayToSort.length; i++)
            r[i - mid] = arrayToSort[i];
        l = sortArray(l);
        r = sortArray(r);
        return merge(l, r);
    }

    public int[] merge(int[] l, int[] r) {
        int i = 0, j = 0, k = 0;
        int[] a = new int[l.length + r.length];
        while (i < l.length && j < r.length) {
            if (l[i] < r[j])
                a[k++] = l[i++];
            else if (l[i] > r[j])
                a[k++] = r[j++];
            else {
                a[k++] = l[i++];
                j++;
                int[] temp = a;
                a = new int[l.length + r.length - 1];
                for (int p = 0; p < a.length; p++)
                    a[p] = temp[p];
            }
        }
        while (i < l.length)
            a[k++] = l[i++];
        while (j < r.length)
            a[k++] = r[j++];
        return a;
    }
}
