package iterator;

import java.util.*;
import java.util.function.Predicate;

public class ListUtils {

    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (i.nextIndex() == index) {
                i.add(value);
                break;
            }
            i.next();
        }
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        boolean flag = false;
        while (i.hasNext()) {
            if (i.previousIndex() == index) {
                flag = true;
                i.add(value);
                break;
            }
            i.next();
        }
        if (!flag) {
            list.add(value);
        }
    }

    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (!filter.test(i.next())) {
                i.remove();
            }
        }
    }

    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (filter.test(i.next())) {
                i.set(value);
            }
        }
    }

    public static <T> void removeAll(List<T> list, List<T> elements) {
        ListIterator<T> first = list.listIterator();
        ListIterator<T> second = elements.listIterator();
        boolean flag = false;
        while (first.hasNext()) {
            while (second.hasNext()) {
                if (list.get(first.nextIndex()) == elements.get(second.nextIndex())) {
                    flag = true;
                    break;
                }
                second.next();
            }
            first.next();
            if (!flag || !second.hasNext()) {
                first.remove();
            }
        }
    }
}
