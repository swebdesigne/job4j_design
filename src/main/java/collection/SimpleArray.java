package collection;

import java.util.*;

public class SimpleArray<T> implements Iterable {
    private Object[] container;
    private int size;
    private int capacity;
    private int modCount = 0;
    private int index = 0;

    public SimpleArray() {
        this.container = new Object[2];
        this.size = 0;
        this.capacity = 2;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) container[index];
    }

    /**
     * Метод добавляет модель в конец массива
     * @param model
     */
    public void add(T model) {
        if (size == capacity) {
            capacity(2);
        }
        container[size] = model;
        size++;
        modCount++;
    }

    /**
     * Метод увеличивает размер capacity
     * @param v
     */
    private void capacity(double v) {
        Object[] temp = new Object[(int) (this.capacity * v)];
        for (int i = 0; i < capacity; i++) {
            temp[i] = container[i];
        }
        container = temp;
        capacity = (int) (capacity * v);
    }

    @Override
    public Iterator<T> iterator() {
        int expectedModcount = modCount;
        System.out.println(expectedModcount + " === " + modCount);
        if (modCount != expectedModcount) {
            throw new ConcurrentModificationException();
        }
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return size < capacity;
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
