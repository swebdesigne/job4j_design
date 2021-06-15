package collection;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable {
    private Object[] container;
    private int size = 0;
    private int index = 0;
    private int change = 0;

    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) container[index];
    }

    public void add(T model) {
        Objects.checkIndex(index, size);
        container[index] = model;
        index++;
        change++;
    }

    @Override
    public Iterator<T> iterator() {
        int expectedModCount = index;
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new  NoSuchElementException();
                }
                return (T) container[index++];
            }
            public void remove() {
                throw new UnsupportedOperationException("Cannot remove an element of an array.");
            }
        };
    }
}
