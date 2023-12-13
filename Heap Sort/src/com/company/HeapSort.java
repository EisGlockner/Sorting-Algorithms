package com.company;

import java.util.Arrays;
import java.util.stream.Collectors;

public class HeapSort {
    void sort(int[] values) {
        int arrLength = values.length;

//        Sorting the Array like a tree from max to min
        for (int parentNode = arrLength / 2 - 1; parentNode >= 0; parentNode--) {
            this.heapify(values, arrLength, parentNode);
        }

//        switch the first value (highest) to the last position and sort the array again from max to min
        for (int parentNode = arrLength-1; parentNode >= 0; parentNode--) {
            this.swapHighest(values, parentNode);
            this.heapify(values, parentNode, 0);
        }
    }

    void heapify(int[] values, int arrLength, int parentNode) {
        int largest = parentNode;
//        With this math formular we always stay at the right or left side of the "tree"
        int left = 2 * parentNode + 1;
        int right = 2 * parentNode + 2;

//        Compares the left side with the element above of it
        if (left < arrLength && values[left] > values[largest]){
            largest = left;
        }
        
//        Compares the right side with the element above of it
        if (right < arrLength && values[right] > values[largest]) {
            largest = right;
        }
//        If the value declared as largest is still the largest, exit the method, else swap and sort again
        if (largest != parentNode) {
            this.swapNewHighest(values, parentNode, largest);
            this.heapify(values, arrLength, largest);
        }
    }

//    Swap function to swap the first position (highest values) to the last spot
    void swapHighest(int[] values, int parentNode) {
        int temp = values[0];
        values[0] = values[parentNode];
        values[parentNode] = temp;
    }

//    Swap function to swap a higher value to the first spot
    void swapNewHighest(int[] values, int parentNode, int largest) {
        int temp = values[parentNode];
        values[parentNode] = values[largest];
        values[largest] = temp;
    }

    void printArray(int[] values) {
        String result = Arrays.stream(values)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" - "));
        System.out.println(result);
    }
}
