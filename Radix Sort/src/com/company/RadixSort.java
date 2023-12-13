package com.company;

import java.util.Arrays;

public class RadixSort {
    public static void sort(int[] intArr) {
//        Finding the highest value, so we can get how many digits it has
        int max = findMaximumValue(intArr);
//        Calculate, how many digits the highest value has
        int digits = calculateDigits(max);
//        needed in the calculation for the single digits
        int placeValue = 1;

//        Do till all digits are checked
        while (digits-- > 0) {
            actualSorting(intArr, placeValue);
//            *10 so we have the first, second and then third digit (or more if there are higher values)
            placeValue *= 10;
        }
    }

    private static void actualSorting(int[] intArr, int placeValue) {
//        used to count the occurrence of each digit
        int range = 10;

//        Each bin in the range from 0 to 9 will have some value based on the frequency of digits
//        Used to position each element in the array
        int[] frequency = new int[range];
        int[] sortedValues = new int[intArr.length];

//        Example first digit: (527 / 1) % 10 = 7 -> frequency[7] += 1
//        Example second digit: (527 / 10) % 10 = 2 -> frequency[2] += 1
//        Example third digit: (527 / 100) % 10 = 5 -> frequency[5] += 1
        for (int i : intArr) {
            int digit = (i / placeValue) % range;
            frequency[digit]++;
        }

//        Example Array with 5 values: [0, 1, 0, 2, 1, 1]
//        After for loop: [0, 1, 1, 3, 4, 5]
        for (int i = 1; i < range; i++) {
            frequency[i] += frequency[i - 1];
        }

        for (int i = intArr.length - 1; i >= 0; i--) {
            int digit = (intArr[i] / placeValue) % range;
            sortedValues[frequency[digit] - 1] = intArr[i];
            frequency[digit]--;
        }

        System.arraycopy(sortedValues, 0, intArr, 0, intArr.length);
    }


    private static int findMaximumValue(int[] intArr) {
        return Arrays.stream(intArr).max().orElseThrow();
    }

    private static int calculateDigits(int max) {
        return (int) Math.log10(max) + 1;
    }
}