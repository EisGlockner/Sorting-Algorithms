package com.company;

public interface ISortCriteria<T extends Comparable<T>> {
    boolean toSwap(T a, T b);
}
