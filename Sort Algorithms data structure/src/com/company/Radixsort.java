package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Radixsort<T extends Comparable<T>> extends ASort<T> {

    private final ISortCriteria<T> defaultCriteria = (T a, T b) -> a.compareTo(b) > 0;

    @Override
    public void sort(List<T> values) {
        this.sort(values, defaultCriteria);
    }

    @Override
    public List<T> sort(List<T> values, ISortCriteria<T> criteria) {
        List<Integer> intValues = new ArrayList<>();
        for(T i : values) {
            intValues.add((Integer) i);
        }
//        Finding the highest value, so we can get how many digits it has
        int max = Collections.max(intValues);
//        Calculate, how many digits the highest value has
        int digits = calculateDigits(max);

//        needed in the calculation for the single digits
        int placeValue = 1;

//        Do till all digits are checked
        while (digits-- > 0) {
            actualSorting(intValues, placeValue);
//            *10 so we have the first, second and then third digit (or more if there are higher values)
            placeValue *= 10;
        }

        List<T> sortedArray = new ArrayList<>();

        for (int i : intValues) {
            sortedArray.add((T)((Integer)i));
        }
        return sortedArray;
    }

    private void actualSorting(List<Integer> values, int placeValue) {
//        Used to count the occurrence of each digit
        int range = 10;

//        Each bin in the range from 0 to 9 will have some value based on the frequency of digits
//        Used to position each element in the array
        List<Integer> frequency = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            frequency.add(0);
        }

        List<Integer> sortedValues = new ArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            sortedValues.add(0);
        }

        for (int value : values) {
            int digit = (value / placeValue) % range;
            frequency.set(digit, frequency.get(digit) + 1);
        }

        for (int i = 1; i < range; i++) {
            frequency.set(i, frequency.get(i) + frequency.get(i - 1));
        }

        for (int i = values.size() - 1; i >= 0; i--) {
            int digit = (values.get(i) / placeValue) % range;
            sortedValues.set(frequency.get(digit) - 1, values.get(i));
            frequency.set(digit, frequency.get(digit) - 1);
        }

        Collections.copy(values, sortedValues);
    }

    private static int calculateDigits(int max) {
        return (int) Math.log10(max) + 1;
    }
}
