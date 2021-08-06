package tree;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        if (findBy(parent).isPresent() && !findBy(child).isPresent()) {
            findBy(parent)
                    .stream()
                    .map(x -> x.children.add(new Node<E>(child)))
                    .collect(Collectors.toList());
            return true;
        }
        return false;
    }

    @Override
    public boolean isBinary() {
        Predicate<Node<E>> predicate = (root -> root.children.size() > 2);
        return findByPredicate(predicate).isEmpty();
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Predicate<Node<E>> predicate = (root -> root.value.equals(value));
        return findByPredicate(predicate);
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}
