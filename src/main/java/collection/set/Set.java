package collection.set;

import java.util.Iterator;

public interface Set<T> extends Iterator<T> {
    boolean add(T value);
    boolean contains(T value);
}
