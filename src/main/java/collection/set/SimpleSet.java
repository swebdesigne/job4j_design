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
        for (int i = 0; i < set.getSize(); i++) {
            if (Objects.equals(set.get(i), value)) {
                return true;
            }
        }
        return false;
    }

    public Iterator<T> iterator() {
        return set.iterator();
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }
}