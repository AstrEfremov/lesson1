package ru.aston.trainee.lesson2.myAraryList;

import java.util.Collection;
import java.util.Comparator;

public interface MyArray<E> {
    boolean add(E e);

    void add(int index, E element);

    void clear();

    E get(int index);

    boolean isEmpty();

    E remove(int index);

    void sort(Comparator<? super E> c);

    int size();
}
