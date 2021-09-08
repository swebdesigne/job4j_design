package ru.job4j.collection.set;

import java.util.Iterator;

public interface Set<T> extends Iterable<T> {
    boolean add(T value);
    boolean contains(T value);
}
