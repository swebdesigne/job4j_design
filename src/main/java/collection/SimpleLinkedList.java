package collection;

import java.util.Iterator;

public class SimpleLinkedList<E> implements List<E> {
    private Node<E> fstNode;
    private Node<E> lstNode;
    private int size = 0;

    public SimpleLinkedList() {
        lstNode = new Node<>(null, fstNode, null);
        fstNode = new Node<>(null, null, lstNode);
    }

    @Override
    public void add(E e) {
        Node<E> prev = lstNode;
        prev.setCurrentElement(e);
        lstNode = new Node<E>(null, prev, null);
        prev.setNextElement(lstNode);
        size++;
        System.out.println(lstNode.getPrevElement());
    }

    @Override
    public E get(int index) {
        Node<E> target = fstNode.getNextElement();
//        System.out.println(target.getCurrentElement());
        for (int i = 0; i < index; i++) {
            target = getNextElement(target);
        }
        return target.getCurrentElement();
    }

    private Node<E> getNextElement(Node<E> current) {
        return current.getNextElement();
    }
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                return get(index++);
            }
        };
    }
}
