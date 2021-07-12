package generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/**
 * Класс описывает работу с массивом
 * @author IGOR SIVOLOBOV
 * @version 1.0
 * @param <T>
 */

public class SimpleArray<T> implements Iterable<T> {
    private Object[] array;
    private int size = 0;
    private int index = 0;

    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    public SimpleArray() {

    }

    /**
     * возвращает элемент, расположенный по указанному индексу
     * @param index - индекс элемента, котрый необходимо вернуть
     * @return
     */
    public Object get(int index) {
        Objects.checkIndex(index, size);
        return array[index];
    }

    /**
     * Добавляет указанный элемент в первую свободную ячейку
     * @param num
     */
    public void add(T num) {
       this.array[size] = num;
       this.size++;
    }

    /**
     * заменяет указанным элементом (model) элемент, находящийся по индексу
     * @param index - индекс элемента, который необходимо заменить
     * @param model
     */
    public void set(int index, T model) {
        Objects.checkIndex(index, size);
        array[index] = model;
    }

    /**
     * удаляет элемент по указанному индексу
     * @param index- индекс элемента, который необходимо удалить
     */
    public void remove(int index) {
        Objects.checkIndex(index, size);
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            public boolean hasNext() {
                return index < size;
            }

            public T next() {
                return (T) array[index++];
            }

            public void remove() {
                throw new UnsupportedOperationException("Cannot remove an element of an array.");
            }
        };
    }
}
