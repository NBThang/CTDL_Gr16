package hashtables;

import java.util.*;

public class SequentialSearch<K, V> { 
        private int n;
        private Node first;

        private class Node {
                private K key;
                private V val;
                private Node next;
                public Node(K k, V val, Node next) {
                        this.key = k;
                        this.val = val;
                        this.next = next;
                }
        }

        public SequentialSearch() {
        }

        public V get(K k) {
                for (Node x = first; x != null; x = x.next) {
                        if (k.equals(x.key))
                                return x.val;
                }
                return null;
        }

        public void set(K k, V val) {
                if (val == null) {
                        delete(k);
                        return;
                }

                for (Node x = first; x != null; x = x.next) {
                        if (k.equals(x.key)) {
                                x.val = val;
                                return;
                        }
                }
                first = new Node(k, val, first);
                n++;
        }

        public int size() {
                return n;
        }

        public boolean isEmpty() {
                return size() == 0;
        }

        public boolean contains(K k) {
                return get(k) != null;
        }

        public void delete(K k) {
                first = delete(first, k);
        }

        private Node delete(Node x, K k) {
                if (x == null)
                        return null;
                if (k.equals(x.key)) {
                        n--;
                        return x.next;
                }
                x.next = delete(x.next, k);
                return x;
        }

        public Iterable<K> keys()  {
                Queue<K> queue = new LinkedList<K>();
                for (Node x = first; x != null; x = x.next)
                        queue.add(x.key);
                return queue;
        }

        
} 
