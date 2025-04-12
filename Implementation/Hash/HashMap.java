package Implementation.Hash;

import java.util.LinkedList;

public class HashMap<K, V> {
    /// LOAD_FACTOR means when the size is 0.75*capacity -> resize
    private static final float LOAD_FACTOR = 0.75f;

    private LinkedList<Entry<K, V>>[] buckets;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public HashMap() {
        capacity = 16;
        buckets = new LinkedList[capacity];
        size = 0;
    }

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public void put(K key, V value) {
        if ((float) size / capacity >= LOAD_FACTOR) {
            resize();
        }

        int index = getBucketIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update
                return;
            }
        }

        buckets[index].add(new Entry<>(key, value));
        size++;
        // Optional: Resize if load factor exceeded
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        if (buckets[index] != null) {
            for (Entry<K, V> entry : buckets[index]) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public boolean remove(K key) {
        int index = getBucketIndex(key);
        if (buckets[index] != null) {
            for (Entry<K, V> entry : buckets[index]) {
                if (entry.key.equals(key)) {
                    buckets[index].remove(entry);
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printMap() {
        for (LinkedList<Entry<K, V>> bucket : buckets) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    System.out.println(entry.key + " = " + entry.value);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        LinkedList<Entry<K, V>>[] oldBuckets = buckets;

        capacity *= 2;
        buckets = new LinkedList[capacity];
        size = 0; // will re-increment in put()

        for (LinkedList<Entry<K, V>> bucket : oldBuckets) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    put(entry.key, entry.value);
                }
            }
        }
    }
}

