package ru.job4j.collection;

import java.util.*;

public class SimpleLinkedList<E> implements List<E> {
    private Node<E> data;
    private int size = 0;
    private int modCount = 0;

    public SimpleLinkedList() {
        data = null;
    }

    @Override
    public void add(E value) {
        if (isEmpty()) {
            data = new Node<E>(value);
        } else {
            Node<E> tmp = data;
            while (tmp.getNextElement() != null) {
                tmp = tmp.getNextElement();
            }
            tmp.setNextElement(new Node<E>(tmp, value, null));
        }
        size++;
        modCount++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> x = data;
        for (int i = 0; i < index; i++) {
            x = x.getNextElement();
        }
        return x.getCurrentElement();
    }

    @Override
    public Iterator<E> iterator() {
        int expectedModCount = modCount;
        return new Iterator<E>() {
            private int index = 0;
            Node<E> current = data;
            @Override
            public boolean hasNext() {
                return  index < size;
            }
            @Override
            public E next() {

                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (index != 0) {
                    current = current.getNextElement();
                }
                index++;
                return current.getCurrentElement();
            }
        };
    }
}
