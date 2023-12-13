package com.company;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Quicksort<T extends Comparable<T>> extends ASort<T> {

    private final ISortCriteria<T> defaultCriteria = (T a, T b) -> a.compareTo(b) > 0;

    @Override
    public void sort(List<T> values) {
        this.sort(values, defaultCriteria);
    }

    @Override
    public List<T> sort(List<T> values, ISortCriteria<T> criteria) {
        quicksort(values, 0, values.size() - 1);
        return values;
    }

    public void quicksort(List<T> values, int lowIndex, int highIndex) {
        if (lowIndex < highIndex + 1) {
            int p = partition(values, lowIndex, highIndex);
            quicksort(values, lowIndex, p - 1);
            quicksort(values, p + 1, highIndex);
        }
    }

    private int partition(List<T> values, int lowIndex, int highIndex) {
        Collections.swap(values, lowIndex, getPivot(lowIndex, highIndex));
        int border = lowIndex + 1;
        for (int i = border; i <= highIndex; i++) {
            if (defaultCriteria.toSwap(values.get(lowIndex), values.get(i))) {
                Collections.swap(values, i, border++);
            }
        }
        Collections.swap(values, lowIndex, border - 1);
        return border - 1;
    }

    private int getPivot(int lowIndex, int highIndex) {
        Random rand = new Random();
        return rand.nextInt((highIndex - lowIndex) + 1) + lowIndex;
    }
}