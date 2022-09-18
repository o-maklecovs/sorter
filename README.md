# Sort manager

Sort manager allows user to select a sorting algorithm that will be used to sort a randomised array of any size that the user specifies. User can also choose to compare two algorithms, in which case the same array gets sorted by two different algorithms and the difference in time it took to sort for each is shown.

## Sorters

Each sorter class extends an abstract class ```Sort```, which implements interface ```Sorter```. This forces all classes that extend ```Sort``` to implement ```sortArray``` method defined in the ```Sorter``` interface and also allows to implement any methods in abstract class ```Sort``` that will be shared by all sorter classes.

### Removing duplicates

```removeDuplicates()``` method is implemented in abstract class ```Sort``` and is available to any classes that extend it. This method takes an array of ints (primitive) and, using an advanced for each loop, adds elements to an array list, while also checking if the current value in the iteration is already in the list. The result of this is an array list without any duplicates. In the end the array list is converted back to an array of primitive ints.

```java
public abstract class Sort implements Sorter {

    public int[] removeDuplicates(int[] arr) {
        List<Integer> arrVals = new ArrayList<>();
        for (int j : arr) {
            if (!arrVals.contains(j))
                arrVals.add(j);
        }
        int[] result = new int[arrVals.size()];
        for (int i = 0; i < result.length; i++)
            result[i] = arrVals.get(i);
        return result;
    }
}
```

### Bubble sort

```sortArray``` method of the ```BubbleSorter``` class uses Bubble sorting algorithm to sort an array of integers. 

```java
public class BubbleSorter extends Sort {

    @Override
    public int[] sortArray(int[] arrayToSort) {
        arrayToSort = removeDuplicates(arrayToSort);
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

### Merge sort

Merge sort algorithm uses a "divide and conquer" strategy. The array is split into two roughly equals parts (recursively) up until the size of both left and right arrays is equal to one. After that the arrays are merged together. This algorithm consists of two methods: one that splits the arrays and one that merges them.

```java
public class MergeSorter extends Sort {

    @Override
    public int[] sortArray(int[] arrayToSort) {
        arrayToSort = removeDuplicates(arrayToSort);
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
    // ...
}
```

#### Merging two ordered arrays

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

### Binary tree sort

Binary tree sorter class takes in an array of integers, converts it to a binary tree and, using tree sort, returns a sorted array of integers.

#### Binary tree node

```Node``` is a nested class contained withing ```BinaryTreeSorter``` class. It represents a node in a binary tree, which has data (an int in this case) and left and right nodes, which are also sometimes called subtrees.

```java
private static class Node {

    private final int data;
    private Node l;
    private Node r;
    
    public Node(int data) { this.data = data; }

    public int getData() { return this.data; }

    public Node getL() { return this.l; }

    public void setL(Node node) { this.l = node; }

    public Node getR() { return this.r; }

    public void setR(Node node) { this.r = node; }
}
```

#### Adding elements to the tree

In a binary tree any data that is smaller than the data in the current node must go to the left subtree, and any data that is larger to the right subtree. This principal is used to insert new nodes into the tree. Note that if the next node in the tree already has a value then ```add()``` method is called recursively, with the next node as one of the arguments to the method.

```java
public class BinaryTreeSorter extends Sort {

    public void add(Node start, int data) {
        if (start.getData() > data) {
            if (start.getL() == null)
                start.setL(new Node(data));
            else
                this.add(start.getL(), data);
        } else {
            if (start.getR() == null)
                start.setR(new Node(data));
            else
                this.add(start.getR(), data);
        }
    }
    // ...
}
```

#### Traversing the tree

In order traversal is used to get the values stored in a binary tree. This type of traversal first searches the left subtree and then the right subtree. Once the algorithm finds that the next node does not exist (i.e. is ```null```) it stops and returns the data from the current node. It then continues the search on the right subtree.

```java
public class BinaryTreeSorter extends Sort {
    // ...
    public void inOrder(Node node, List<Integer> vals) {
        if (node != null) {
            this.inOrder(node.getL(), vals);
            vals.add(node.getData());
            this.inOrder(node.getR(), vals);
        }
    }
    // ...
}
```

#### Sorting an array

To sort an array ```sortArray()``` method uses ```add()``` to create a Binary tree and add the values from the array to it. Then ```inOrder()``` method is used to retrieve all values from the tree. The result of all this is a sorted array of integers, which is converted to an array of primitive ints before returning it.

```java
public class BinaryTreeSorter extends Sort {
    // ...
    public int[] sortArray(int[] arrayToSort) {
        if (arrayToSort.length < 1)
            return arrayToSort;
        arrayToSort = removeDuplicates(arrayToSort);
        Node newNode = new Node(arrayToSort[0]);
        for (int i = 1; i < arrayToSort.length; i++) {
            this.add(newNode, arrayToSort[i]);
        }
        List<Integer> vals = new ArrayList<>();
        inOrder(newNode, vals);
        int[] result = new int[vals.size()];
        for (int i = 0; i < result.length; i++)
            result[i] = vals.get(i);
        return result;
    }
    // ...
}
```

## View

```DisplayManager``` class contains a number of methods that print data to the console, capture and return user input and handle invalid input. Cases of invalid input being submitted are logged. Below is an example of one of ```DisplayManager```'s methods.

```java
public class DisplayManager {
    // ...
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
    // ...
}
```

## Utility classes

```utils``` package contains a class for creating an array of random values. ```build()``` method of ```RandArrayBuilder``` class accepts the size of an array as an argument, generates the array and returns it as the result. The largest random value in the array is determined by its size, i.e. if the size of the array is 100 then the largest possible value in the array will be 100.

```java
public class RandArrayBuilder {

    public int[] build(int size) {
        Random rand = new Random();
        int[] result = new int[size];
        for (int i = 0; i < size; i++)
            result[i] = rand.nextInt(size);
        return result;
    }
}
```

## Controller

```controller``` package contains the controller class, an enum class and a factory class.

### Sorter enum

```SorterTypes``` enum contains all possible names of sorters in this project. When adding a new sorter type a new value must be added to this enum. This enum is used with the factory class to instantiate sorters.

```java
public enum SorterTypes {
    BUBBLE, MERGE, BINARY
}
```

### Factory

```SorterFactory``` class is responsible for creating and returning instances of sorters depending on the value supplied as an argument to the ```getSorter()``` method.

```java
public class SorterFactory {

    public Sort getSorter(SorterTypes type) {
        return switch (type) {
            case BUBBLE -> new BubbleSorter();
            case MERGE -> new MergeSorter();
            case BINARY -> new BinaryTreeSorter();
        };
    }
}
```

### Controller

```SortManager``` class is responsible for calling various methods of both model and view classes (sorters and ```DisplayManager``` respectively), i.e. it controls the behaviours of the program. It has a ```run()``` method, which is the starting point of the program and is called in the main method.

```java
public class SortManager {
    // ...
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
        // ...
    }
    // ...
}
```

```java
public class Main {
    public static void main(String[] args) {
        SortManager.getSortManager().run();
    }
}
```

There are also some additional methods for retrieving sorter instance from the factory, building an array using the array builder class and matching user input.

```java
public class SortManager {
    // ...
    public Sort getSorter(SorterTypes type) {
        SorterFactory factory = new SorterFactory();
        return factory.getSorter(type);
    }
    // ...
    public Sort matchType(int type) {
        switch (type) {
            case 1 -> { return this.getSorter(SorterTypes.BUBBLE); }
            case 2 -> { return this.getSorter(SorterTypes.MERGE); }
            case 3 -> { return this.getSorter(SorterTypes.BINARY); }
        }
        return this.getSorter(SorterTypes.BUBBLE);
    }
    // ...
}
```

```SortManager``` was built using a singleton pattern, which makes it impossible to create more than one instance of this class.

```java
public class SortManager {

    private static final SortManager sortManager = new SortManager();

    private SortManager() { }

    public static SortManager getSortManager() { return sortManager; }
    // ...
}
```