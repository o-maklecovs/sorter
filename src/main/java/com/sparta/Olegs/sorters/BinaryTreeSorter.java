package com.sparta.Olegs.sorters;

import java.util.List;
import java.util.ArrayList;

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

    public void inOrder(Node node, List<Integer> vals) {
        if (node != null) {
            this.inOrder(node.getL(), vals);
            vals.add(node.getData());
            this.inOrder(node.getR(), vals);
        }
    }

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

    private static class Node {

        private final int data;
        private Node l;
        private Node r;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return this.data;
        }

        public Node getL() {
            return this.l;
        }

        public void setL(Node node) {
            this.l = node;
        }

        public Node getR() {
            return this.r;
        }

        public void setR(Node node) {
            this.r = node;
        }
    }
}
