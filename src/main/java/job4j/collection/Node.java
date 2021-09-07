package job4j.collection;

public class Node<E> {
    private E data;
    private Node<E> next;
    private Node<E> prev;

    Node(E data) {
        this(null, data, null);
    }

    Node(Node<E> prevElement, E data, Node<E> nextElement) {
        this.data = data;
        this.next = nextElement;
        this.prev = prevElement;
    }

    public E getCurrentElement() {
        return data;
    }

    public E getData() {
        return data;
    }

    public void setCurrentElement(E currentElement) {
        this.data = currentElement;
    }

    public Node<E> getNextElement() {
        return next;
    }

    public void setNextElement(Node<E> nextElement) {
        this.next = nextElement;
    }

    public Node<E> getPrevElement() {
        return prev;
    }

    public void setPrevElement(Node<E> prevElement) {
        this.prev = prevElement;
    }
}