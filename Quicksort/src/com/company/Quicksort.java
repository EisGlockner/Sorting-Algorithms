package com.company;

import java.util.Random;

public class Quicksort {
    void sort(int[] intArr, int lowIndex, int highIndex) {
        if (lowIndex < highIndex + 1) {
            int p = partition(intArr, lowIndex, highIndex);
            sort(intArr, lowIndex, p - 1);
            sort(intArr, p + 1, highIndex);
        }
    }

    private int partition(int[] intArr, int lowIndex, int highIndex) {
        swap(intArr, lowIndex, getPivot(lowIndex, highIndex));
        int border = lowIndex + 1;

        for (int i = border; i <= highIndex; i++) {
            if (intArr[i] < intArr[lowIndex]) {
                swap(intArr, i, border++);
            }
        }

        swap(intArr, lowIndex, border - 1);
        return border - 1;
    }

    private void swap(int[] intArr, int a, int b) {
        int temp = intArr[a];
        intArr[a] = intArr[b];
        intArr[b] = temp;
    }

    private int getPivot(int lowIndex, int highIndex) {
        Random rand = new Random();
        return rand.nextInt((highIndex - lowIndex) + 1) + lowIndex;
    }
}
