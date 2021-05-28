package generics;

import java.util.Iterator;
import java.util.Objects;

/**
 * Класс описывает работу с масством
 * @author IGOR SIVOLOBOV
 * @version 1.0
 * @param <T>
 */

public class SimpleArray<T> implements Iterator {
    private Object[] array;
    private int size = 0;
    int index = 0;

    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    /**
     * возвращает элемент, расположенный по указанному индексу
     * @param index - индекс элемента, котрый необходимо вернуть
     * @return
     */
    public Object get(int index) {
        return array[index];
    }

    /**
     * Добавляет указанный элемент в первую
     * свободную ячейку
     * @param num
     */
    public void add(T num) {
       this.array[size] = num;
       this.size++;
    }

    /**
     * заменяет указанным элементом (model) элемент, находящийся по индексу index;
     * @param index - индекс элемента, котрый необходимо заменить
     * @param model
     */
    public void set(int index, T model) {
        Objects.checkIndex(index, size);
        array[index] = model;
    }

    /**
     * удаляет элемент по указанному индекс
     * @param index- индекс элемента, котрый необходимо удалить
     */
    public void remove(int index) {
        Objects.checkIndex(index, size);
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
    }

    /**
     * проверяет, если ли следующий элемент
     * @return
     */
    @Override
    public boolean hasNext() {
        return index < size;
    }

    /**
     * итерирует элемент
     * @return - возвращает элемент по индексу
     */
    @Override
    public Object next() {
        return array[index++];
    }
}
