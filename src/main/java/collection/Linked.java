package collection;

public interface Linked<E> {
    void addLast(E e);
    void addFirst(E e);
    E getElementByIndex(int counter);
}
