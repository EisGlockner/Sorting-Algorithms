package com.company;

import java.util.Random;

class Bogosort {
    private final int arrLength;
    private final int[] intArr;
    private final Random rnd = new Random();
    private final int range;

    Bogosort(final int arrLength, final int range) {
        this.arrLength = arrLength;
        this.range = range;
        this.intArr = new int[arrLength];
        for (int i = 0; i < this.arrLength; ++i) {
            this.intArr[i] = this.rnd.nextInt(range);
        }
    }

    void printArray() {
        for (int temp : this.intArr) {
            System.out.print(temp + " ");
        }
        System.out.println();
    }

    void sorting() {
        long counter = 0;
        printArray();
        for (int i = 0; i < range; i++) {
            while (!isSorted()) {
                for (int j = 0; j < this.arrLength; ++j) {
                    int tempA = this.rnd.nextInt(this.arrLength);
                    int tempB = this.rnd.nextInt(this.arrLength);

                    int temp = intArr[tempA];
                    this.intArr[tempA] = this.intArr[tempB];
                    this.intArr[tempB] = temp;
                }
                ++counter;
            }
        }
        printArray();
        System.out.println(counter + " Tries till sorted");
    }

    boolean isSorted() {
        for (int i = 0; i < this.arrLength - 1; ++i) {
            if (this.intArr[i] > this.intArr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
