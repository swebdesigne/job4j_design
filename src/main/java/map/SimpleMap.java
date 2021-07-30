package map;

import collection.Node;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {
    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private Node<K> data;

    private MapEntry<K, V>[] table = new MapEntry[capacity];


    @Override
    public boolean put(K key, V value) {
        int hash = hash(key.hashCode());
        int i = indexFor(hash, table.length);
        MapEntry<K, V> e = table[i];
        for (int j = 0; j < count; j++) {
            Object k;
            if (hash(e.hashCode()) == hash || key.equals(e.key)) {
                V oldValue = e.value;
                e.value = value;
                table[j] = (MapEntry<K, V>) oldValue;
                modCount++;
            }
        }
        modCount++;
        return false;
    }

    private int hash(Integer key) {
        int h;
        return key == null ? 0 : (h = key.hashCode()) ^ (h >> 16);
    }

    private int indexFor(int h, int length) {
        return h & (length-1);
    }

    private void expand() {

    }

    public int hashCode(int charValue) {
        int result = 17;
        result = 37 * result + charValue;
        return result;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public boolean remove(K key) {
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        int expectedModCount = modCount;
        return new Iterator<K>() {
            private int index = 0;
            Node<K> current = data;
            @Override
            public boolean hasNext() {
                return  index < table.length;
            }
            @Override
            public K next() {

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

    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
