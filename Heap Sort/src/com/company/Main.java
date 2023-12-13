package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
//        arrRange: How many values should be in the Array | Bound: from zero to "number" should the numbers be
        new Main().runSort(12000000, 100000000);
    }

    public void runSort(int arrRange, int bound) {
        Random rnd = new Random();
        int[] values = new int[arrRange];

//        Fill the Array with random numbers
        for (int i = 0; i < values.length; i++) {
            values[i] = rnd.nextInt(bound);
        }

        HeapSort heapSort = new HeapSort();

//        Printing, sorting, printing
//        this.printArray(values);
        long startTime = System.currentTimeMillis();
        heapSort.sort(values);
        long stopTime = System.currentTimeMillis();
        System.out.println((stopTime - startTime) / 1000 + " sekunden");
//        this.printArray(values);
    }

//    Print Method with a join function
    private void printArray(int[] values) {
        String result = Arrays.stream(values)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" - "));
        System.out.println(result);
    }
}
