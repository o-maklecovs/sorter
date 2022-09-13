# Sorter

# Bubble sort

```sortArray``` method of the ```BubbleSorter``` class uses Bubble sorting algorithm to sort an array of integers. 

```java
public class BubbleSorter implements Sorter {

    public int[] sortArray(int[] arrayToSort) {
        for (int i = 0; i < arrayToSort.length; i++) {
            for (int k = 0; k < arrayToSort.length - i - 1; k++) {
                if (arrayToSort[k] > arrayToSort[k + 1]) {
                    int temp = arrayToSort[k + 1];
                    arrayToSort[k + 1] = arrayToSort[k];
                    arrayToSort[k] = temp;
                }
            }
        }
        return arrayToSort;
    }
}
```

This method iterates through an array, compares the current and next elements and swaps them depending on their values (the smallest first). The algorithm puts the largest values at the end of the array, so it does not need to iterate through the entire array every time. 

## Merging two ordered arrays

```merge()``` method of the ```MergeSorter``` class takes two ordered arrays as arguments, then sorts and merges them.

```java
public class MergeSorter {
    public int[] merge(int[] l, int[] r) {
        int i = 0, j = 0, k = 0;
        int[] a = new int[l.length + r.length];
        while (i < l.length && j < r.length) {
            if (l[i] <= r[j])
                a[k++] = l[i++];
            else
                a[k++] = r[j++];
        }
        // ...
    }
}
```

This method compares elements of both arrays and appends the smallest of the two to a new array. The reference to the largest element is kept and compared to the next element in the opposite array up until that element is smaller.

If the arrays have different lengths then the rest of the larger array is appended to an array that will be returned as the result.

```java
public class MergeSorter {
    public int[] merge(int[] l, int[] r) {
        // ...
        while (i < l.length)
            a[k++] = l[i++];
        while (j < r.length)
            a[k++] = r[j++];
        return a;
    }
}
```