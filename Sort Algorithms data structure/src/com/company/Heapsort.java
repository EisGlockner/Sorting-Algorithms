package com.company;

import java.util.List;

public class Heapsort<T extends Comparable<T>> extends ASort<T> {

    private final ISortCriteria<T> defaultCriteria = (T a, T b) -> a.compareTo(b) > 0;

    @Override
    public void sort(List<T> values) {
        this.sort(values, defaultCriteria);
    }

    @Override
    public List<T> sort(List<T> values, ISortCriteria<T> criteria) {
        int arrLength = values.size();

//        Sorting the Array like a tree from max to min
        for (int parentNode = arrLength / 2 - 1; parentNode >= 0; parentNode--) {
            this.heapify(values, arrLength, parentNode);
        }

//        switch the first value (highest) to the last position and sort the array again from max to min
        for (int parentNode = arrLength-1; parentNode >= 0; parentNode--) {
            swap(values, 0, parentNode);
            heapify(values, parentNode, 0);
        }
        return null;
    }

    private void heapify(List<T> values, int arrLength, int parentNode) {
        int largest = parentNode;
//        With this math formular we always stay at the right or left side of the "tree"
        int left = 2 * parentNode + 1;
        int right = 2 * parentNode + 2;

//        Compares the left side with the element above of it
        if (left < arrLength && defaultCriteria.toSwap(values.get(left), values.get(largest))) {
            largest = left;
        }

//        Compares the right side with the element above of it UwU
        if (right < arrLength && defaultCriteria.toSwap(values.get(right), values.get(largest))) {
            largest = right;
        }
//        If the value declared as largest is still the largest, exit the method, else swap and sort again
        if (largest != parentNode) {
            swap(values, parentNode, largest);
            this.heapify(values, arrLength, largest);
        }
    }
}
