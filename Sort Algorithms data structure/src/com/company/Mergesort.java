package com.company;

import java.util.ArrayList;
import java.util.List;

class Mergesort<T extends Comparable<T>> extends ASort<T> {

    private final ISortCriteria<T> defaultCriteria = (T a, T b) -> a.compareTo(b) < 0;

    @Override
    public void sort(List<T> values) {
        this.sort(values, defaultCriteria);
    }

    @Override
    public List<T> sort(List<T> values, ISortCriteria<T> criteria) {
        values = this.mergesort(values);
        return values;
    }

    List<T> mergesort(List<T> values) {
        if (values.size() <= 1) {
            return values;
        }

        List<T> left = new ArrayList<>();
        List<T> right = new ArrayList<>();

        for (int i = 0; i < (values.size() / 2); i++) {
            left.add(values.get(i));
        }
        for (int i = (values.size() / 2); i < values.size(); i++) {
            right.add(values.get(i));
        }

        List<T> result;

        left = mergesort(left);
        right = mergesort(right);
        result = merge(left, right);

        return result;
    }

    ArrayList<T> merge(List<T> left, List<T> right) {
        ArrayList<T> result = new ArrayList<>();

        while (left.size() != 0 && right.size() != 0) {
            if (defaultCriteria.toSwap(left.get(0), right.get(0))) {
                result.add(left.get(0));
                left.remove(0);
            } else {
                result.add(right.get(0));
                right.remove(0);
            }
        }
        while (left.size() != 0) {
            result.add(left.get(0));
            left.remove(0);
        }
        while (right.size() != 0) {
            result.add(right.get(0));
            right.remove(0);
        }
        return result;
    }
}
