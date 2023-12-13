package com.company;

import java.util.List;

class Bubblesort<T extends Comparable<T>> extends ASort<T> {

    private final ISortCriteria<T> defaultCriteria = (T a, T b) -> a.compareTo(b) > 0;

    @Override
    public void sort(List<T> values) {
        this.sort(values, defaultCriteria);
    }

    @Override
    public List<T> sort(List<T> values, ISortCriteria<T> criteria) {
        for (int i = 0; i < values.size(); i++) {
            for (int j = 0; j < (values.size() - 1); j++) {
                if (criteria.toSwap(values.get(j), values.get(j + 1))) {
                    swap(values, j, j + 1);
                }
            }
        }
        return null;
    }
}
