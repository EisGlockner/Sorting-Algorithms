package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] bubble = {62, 3, 624, 747, 123, 67, 346, 3, 9993};

        for (int i = 0; i < bubble.length; i++) {
            for (int j = 0; j < bubble.length - 1; j++) {
                if (bubble[j] > bubble[j + 1]) {
                    int temp = bubble[j];
                    bubble[j] = bubble[j + 1];
                    bubble[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(bubble));
    }
}
