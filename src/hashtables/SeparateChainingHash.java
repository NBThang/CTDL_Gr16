package hashtables;

import java.util.*;

public class SeparateChainingHash<K, V> {

    private int n;
    private int N;
    private SequentialSearch<K, V>[] seqSearch;

    public SeparateChainingHash() {
        this(997);
    }

    public SeparateChainingHash(int N) {
        this.N = N;
        seqSearch = (SequentialSearch<K, V>[]) new SequentialSearch[N];
        for (int i = 0; i < N; i++) {
            seqSearch[i] = new SequentialSearch<>();
        }
    }

    private int hash(K key) {
        int h = key.hashCode();
        h ^= (h >>> 20) ^ (h >>> 12) ^ (h >>> 7) ^ (h >>> 4);
        return h & (N - 1);
    }

    public V get(K key) {
        return seqSearch[hash(key)].get(key);
    }

    private void resize(int size) {
        SeparateChainingHash<K, V> temp = new SeparateChainingHash<>(size);
        for (int i = 0; i < N; i++) {
            for (K key : seqSearch[i].keys()) {
                temp.set(key, seqSearch[i].get(key));
            }
        }
        this.n = temp.n;
        this.N = temp.N; 
        this.seqSearch = temp.seqSearch;
    } 

    public void set(K key, V val) {
        if (val == null) {
            delete(key);
            return;
        }

        if (key == null) {
            return;
        }
        if (n >= 10 * N) {
            resize(2 * N);
        }
        if (!seqSearch[hash(key)].contains(key)) {
            n++;
        }
        seqSearch[hash(key)].set(key, val);
    }

    public void delete(K key) {
        if (key == null) {
            return;
        }
        if (seqSearch[hash(key)].contains(key)) {
            n--;
        }
        seqSearch[hash(key)].delete(key);
        if (N > 0 && n <= 2 * N) {
            resize(N / 2);
        }
    }

    public Iterable<K> keys() {
        Queue<K> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (K key : seqSearch[i].keys()) {
                queue.add(key);
            }
        }
        return queue;
    }

    void print() {
        for (int i = 0; i < N; i++) {
            System.out.print(i + ": ");
            for (K key : seqSearch[i].keys()) {
                System.out.println(key);
            }
        }
    }

    public V search(K key) { 
        return seqSearch[hash(key)].get(key);
    }
}
