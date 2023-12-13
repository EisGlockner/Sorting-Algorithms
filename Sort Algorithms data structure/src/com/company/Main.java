package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        new Main().runSort();
    }

    private void runSort() {
        DecimalFormat f = new DecimalFormat("#0.00");
        Heapsort<Integer> heapsort = new Heapsort<>();
        Bubblesort<Integer> bubblesort = new Bubblesort<>();
        Mergesort<Integer> mergesort = new Mergesort<>();
        Radixsort<Integer> radixsort = new Radixsort<>();
        Quicksort<Integer> quicksort = new Quicksort<>();
        List<Integer> values = new ArrayList<>();
        generateList(values);

        double startTime = System.currentTimeMillis();
//        values = mergesort.sort(values, (a, b) -> a.compareTo(b) > 0);
        values = radixsort.sort(values, (a, b) -> a.compareTo(b) > 0);
//        values = quicksort.sort(values, (a, b) -> a.compareTo(b) > 0);
//        heapsort.sort(values, (a, b) -> a.compareTo(b) > 0);
//        bubblesort.sort(values, (a, b) -> a.compareTo(b) > 0);
        double stopTime = System.currentTimeMillis();
//        System.out.println(values);
        System.out.println((stopTime - startTime) / 1000 + " sekunden");
    }

    void generateList(List<Integer> values){
        Random rnd = new Random();

        for (int i = 0; i < 12000000; i++){
            values.add(rnd.nextInt(100000000));
        }
//        System.out.println(values);
    }
}
