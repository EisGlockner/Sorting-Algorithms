package com.company;

import java.util.List;

public interface ISort<T extends Comparable<T>> {
    void sort(List<T> values);
    List<T> sort(List<T> values, ISortCriteria<T> criteria);
}
