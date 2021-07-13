package collection.set;

import generics.SimpleArray;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Set<T> {
    private SimpleArray<T> set = new SimpleArray<>(10);

    @Override
    public boolean add(T value) {
        if (!contains(value)) {
            set.add(value);
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(T value) {
        while (iterator().hasNext()) {
            if (Objects.equals(iterator().next(), value)) {
                return true;
            }
        }
        return false;
    }

    public Iterator<T> iterator() {
        return set.iterator();
    }
}