package queue;

import java.util.Iterator;

public class ArrayQueue<E> implements QueueInterface<E> {
    private E[] queue;
    private int n = 0;
    private int top = 0;
    private int count = 0;
    private int default_size = 100;

    public ArrayQueue(int capacity) {
        n = capacity;
        queue = (E[]) new Object[capacity];
    }

    public ArrayQueue() {
        n = default_size;
        queue = (E[]) new Object[default_size];
    }

    public int size() {
        return count;
    }

    @Override
    public void enqueue(E element) throws IllegalStateException {
        if (count == queue.length) throw new IllegalStateException("Queue is full");
        int avail = (top + count) % queue.length;
        count++;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            return null;
        E answer = queue[top];
        queue[top] = null;
        top = (top + 1) % queue.length;
        count--;
        return answer;
    }

    @Override
    public boolean isEmpty() {
        return (count == 0);
    }


    public Iterator<E> iterator() {
        return  new ArrayQueueIterator();
    }

    class ArrayQueueIterator implements Iterator<E> {
        private int current = top;
        private int num = 0;

        public boolean hasNext() {

            return num < count;
        }

        public E next() {
            E data = queue[(current + num) % n];
            num++;
            return data;
        }
    }
}