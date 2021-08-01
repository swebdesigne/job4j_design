package map;

import collection.Node;
import map.Map;

import java.util.*;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;
    private int count = 0;
    private int modCount = 0;
    private int capacity = 8;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (capacity * LOAD_FACTOR == count) {
            expand();
        }
        int index = indexFor(hash(key));
        if (checkIsIndex(index, key)) {
            MapEntry<K, V> newElem = new MapEntry<>(key, value);
            count++;
            modCount++;
            table[index] = newElem;
            return true;
        }
        return false;
    }

    private boolean checkIsIndex(int index, K key) {
        if (table[index] == null || table[index].getKey().equals(key)) {
            return true;
        }
        return false;
    }

    @Override
    public V get(K key) {
        MapEntry<K, V> searchElement = table[indexFor(hash(key))];
        if (searchElement == null) {
            return null;
        }
        return searchElement.getKey().equals(key) ? searchElement.getValue() : null;
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {
        MapEntry<K, V>[] newTable = new MapEntry[capacity * 2];
        if (count != 0) {
            for (MapEntry<K, V> elem : table) {
                if (elem != null) {
                    int index = indexFor(hash(elem.getKey()));
                    newTable[index] = elem;
                }
            }
        }
        table = newTable;
    }

    private int hash(K key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    @Override
    public boolean remove(K key) {
        int index = indexFor(hash(key));
        if (table[index] == null) {
            return false;
        }
        if (table[index].getKey().equals(key)) {
            table[index] = null;
            count--;
            modCount++;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            int cursor = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (count == 0) {
                    return false;
                }
                for (int i = cursor; i < capacity; i++) {
                    if (table[i] != null) {
                        cursor = i;
                        return true;
                    }
                }
                return false;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return (K) table[cursor++].getValue();
            }
        };
    }

    private static class MapEntry<K, V> {
        private K key;
        private V value;
        private List<MapEntry<K, V>> nodes;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
            nodes = new LinkedList<MapEntry<K, V>>();
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        private List<MapEntry<K, V>> getNodes() {
            return nodes;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            MapEntry<?, ?> mapEntry = (MapEntry<?, ?>) o;
            return Objects.equals(key, mapEntry.key)
                    && Objects.equals(value, mapEntry.value)
                    && Objects.equals(nodes, mapEntry.nodes);
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = result * 37 + key.hashCode();
            return result;
        }

    }

}