package com.company;

import java.util.List;

public abstract class ASort<T extends Comparable<T>> implements ISort<T> {
        void swap(List<T> values, int a, int b) {
        T temp = values.get(a);
        values.set(a, values.get(b));
        values.set(b, temp);
    }
}
