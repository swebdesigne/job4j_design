
public class Node<E> {
    private E currentElement;
    private Node<E> nextElement;
    private Node<E> prevElement;

    private Node(E currentElement, Node<E> nextElement, Node<E> prevElement) {
        this.currentElement = currentElement;
        this.nextElement = nextElement;
        this.prevElement = prevElement;
    }

    public E getCurrentElement() {
        return currentElement;
    }

    public void setCurrentElement(E currentElement) {
        this.currentElement = currentElement;
    }

    public Node<E> getNextElement() {
        return nextElement;
    }

    public void setNextElement(Node<E> nextElement) {
        this.nextElement = nextElement;
    }

    public Node<E> getPrevElement() {
        return prevElement;
    }

    public void setPrevElement(Node<E> prevElement) {
        this.prevElement = prevElement;
    }
}