package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        new Main().runRadixSort();
    }

    private void runRadixSort() {
        Random rnd = new Random();
        int range = 1000000;
        int[] intArr = new int[range];

        for (int i = 0; i < range; i++) {
            intArr[i] = rnd.nextInt(1000000000);
        }

//        this.printArray(intArr);
        double startTime = System.currentTimeMillis();
        RadixSort.sort(intArr);
        double stopTime = System.currentTimeMillis();
//        this.printArray(intArr);
        System.out.println((stopTime - startTime) / 1000 + " sekunden");
    }

    private void printArray(int[] intArr) {
        String result = Arrays.stream(intArr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" - "));
        System.out.println(result);
    }
}
