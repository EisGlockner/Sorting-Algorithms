package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	new Main().runSort(1_000_000, 1_000_000_000);
    }

    private void runSort(int range, int bound) {
        Quicksort quicksort = new Quicksort();
        Random rnd = new Random();

        int[] intArr = new int[range];

        for (int i = 0; i < range; i++) {
            intArr[i] = rnd.nextInt(bound);
        }

//        System.out.println(Arrays.toString(intArr));
        double startTime = System.currentTimeMillis();
        quicksort.sort(intArr, 0, intArr.length-1);
        double stopTime = System.currentTimeMillis();
//        System.out.println(Arrays.toString(intArr));
        System.out.println((stopTime - startTime) / 1000 + " sekunden");
    }

//    private void printArray(int[] intArr) {
//        String result = Arrays.stream(intArr)
//                .mapToObj(String::valueOf)
//                .collect(Collectors.joining(" - "));
//        System.out.println(result);
//    }
}
