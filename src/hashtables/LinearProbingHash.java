package hashtables;

public class LinearProbingHash<K, V> {

    private int n;
    private int N;
    private K[] keys;
    private V[] vals;

    public LinearProbingHash() { 
        this(16); 
    }

    public LinearProbingHash(int N) { 
        this.N = N;
        keys = (K[]) new Object[N];
        vals = (V[]) new Object[N];
    }

    private int hash(K key) { 
        int h = key.hashCode(); 
        h ^= (h >>> 20) ^ (h >>> 12) ^ (h >>> 7) ^ (h >>> 4); 
        return h & (N - 1); 
    }
        
    public V get(K key) { 
        for (int i = hash(key); keys[i] != null; i = (i + 1) % N) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }
        
    private void resize(int size) { 
        LinearProbingHash<K, V> temp = new LinearProbingHash<>(size);
        for (int i = 0; i < N; i++) {
            if (keys[i] != null) {
                temp.set(keys[i], vals[i]);
            }
        }
        this.n = temp.n;
        this.N = temp.N;
        this.keys = temp.keys;
        this.vals = temp.vals;
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
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % N) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }

    public void delete(K key) { 
        if (!contains(key)) {
            return;
        }
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % N;
        }
        keys[i] = null;
        vals[i] = null;
        i = (i + 1) % N;
        while (keys[i] != null) {
            K keyToRedo = keys[i];
            V valToRedo = vals[i];
            keys[i] = null;
            vals[i] = null;
            n--;
            set(keyToRedo, valToRedo);
            i = (i + 1) % N;

        }
        n--;
        if (n > 0 && n <= 2 * N) {
            resize(N / 2);
        }

    }

    private boolean contains(K key) { 
        return get(key) != null;
    }

    public V search(K key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % N) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }
}
