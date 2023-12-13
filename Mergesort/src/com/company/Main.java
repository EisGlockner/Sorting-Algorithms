package com.company;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rnd = new Random();
        int range = 100000000;
        int[] intArr = new int[range];

        for (int i = 0; i < range; i++) {
            intArr[i] = rnd.nextInt(100000000);
        }

        double startTime = System.currentTimeMillis();
        intArr = mergeSort(intArr);
        double stopTime = System.currentTimeMillis();
        System.out.println((stopTime - startTime) / 1000 + " sekunden");
    }

//        Printing the Array
    private static void printArray(int[] intArr) {
        for (int temp : intArr) {
            System.out.print(temp + " ");
        }
        System.out.println();
    }

    private static int[] mergeSort(int[] intArr) {
//        Checks if there is only one number left in the array
        if (intArr.length <= 1) {
            return intArr;
        }

//        middle position of the Array to initialise left and right side
        int middle = intArr.length / 2;
        int[] left = new int[middle];
        int[] right;

//        checks if the Array got an even or uneven amount of numbers
        if (intArr.length % 2 == 0) {
            right = new int[middle];
        } else {
            right = new int[middle + 1];
        }

        System.arraycopy(intArr, 0, left, 0, middle);

        System.arraycopy(intArr, middle, right, 0, right.length);

        int[] result;

        left = mergeSort(left);
        right = mergeSort(right);
        result = merge(left, right);

        return result;
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int leftCounter = 0;
        int rightCounter = 0;
        int resultCounter = 0;

//        Do till there are no numbers left in the Array
        while (leftCounter < left.length || rightCounter < right.length) {
//            If there are still number in the right and left side, initialize the smaller one into the Array
            if (leftCounter < left.length && rightCounter < right.length) {
//                Compares if the left Array number is smaller
                if (left[leftCounter] < right[rightCounter]) {
                    result[resultCounter++] = left[leftCounter++];
//                    Compares if the right Array number is smaller
                } else {
                    result[resultCounter++] = right[rightCounter++];
                }
            } else if (leftCounter < left.length) {
                result[resultCounter++] = left[leftCounter++];
            } else {
                result[resultCounter++] = right[rightCounter++];
            }
        }
        return result;
    }
}
