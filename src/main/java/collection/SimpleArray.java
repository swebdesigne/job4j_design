package collection;

import java.util.*;

public class SimpleArray<T> implements Iterable {
    private Object[] container;
    private int size;
    private int modCount = 0;
    private int index = 0;

    public SimpleArray() {
        this.container = new Object[10];
        this.size = 0;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) container[index];
    }

    public void add(T model) {
        if (size == container.length) {
            capacity();
        }
        container[size] = model;
        size++;
        modCount++;
    }

    public int getCapacity() {
        return container.length;
    }

    private void capacity() {
        Object[] temp = new Object[(int) (container.length * 2)];
        for (int i = 0; i < container.length; i++) {
            temp[i] = container[i];
        }
        container = Arrays.copyOf(temp, temp.length);
    }

    @Override
    public Iterator<T> iterator() {
        int expectedModCount = modCount;
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
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return (T) container[index++];
            }
            public void remove() {
                throw new UnsupportedOperationException("Cannot remove an element of an array.");
            }
        };
    }
}
