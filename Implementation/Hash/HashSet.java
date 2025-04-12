package Implementation.Hash;

import java.util.LinkedList;

public class HashSet<T> {
    private static final int INITIAL_CAPACITY = 16;
    private LinkedList<T>[] buckets;
    private int size;

    @SuppressWarnings("unchecked")
    public HashSet() {
        buckets = new LinkedList[INITIAL_CAPACITY];
        size = 0;
    }

    private int getBucketIndex(T element) {
        return Math.abs(element.hashCode()) % buckets.length;
    }

    public boolean add(T element) {
        int index = getBucketIndex(element);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        if (!buckets[index].contains(element)) {
            buckets[index].add(element);
            size++;
            return true;
        }
        return false;
    }

    public boolean contains(T element) {
        int index = getBucketIndex(element);
        if (buckets[index] == null) return false;
        return buckets[index].contains(element);
    }

    public boolean remove(T element) {
        int index = getBucketIndex(element);
        if (buckets[index] != null && buckets[index].remove(element)) {
            size--;
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                buckets[i].clear();
            }
        }
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printSet() {
        for (LinkedList<T> bucket : buckets) {
            if (bucket != null) {
                for (T item : bucket) {
                    System.out.print(item + " ");
                }
            }
        }
        System.out.println();
    }
}
