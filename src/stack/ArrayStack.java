package stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<E> implements StackInterface<E> {
    public static final int CAPACITY = 1000;
    private E[] data;
    private int t = -1;
    public ArrayStack() {
        this(CAPACITY);
    }

    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }
    public int size() {
        return (t + 1);
    }



    public void push(E element) throws IllegalMonitorStateException {
        if (size() == data.length) throw new IllegalStateException("Stack is full");
        data[++t] = element;
    }

    public E pop() {
        if (isEmpty())
            return null;
        E answer = data[t];
        data[t] = null;
        t--;
        return answer;
    }

    public boolean isEmpty() {
        return (t == -1);
    }

    public E top() {
        if (isEmpty())
            return null;
        return data[t];
    }

    public Iterator<E> iterator() {
        return new ArrayStackIterator();
    }

    private class ArrayStackIterator implements Iterator<E> {
        private int currentIndex;

        public ArrayStackIterator() {
            currentIndex = 0;
        }


        @Override
        public boolean hasNext() {
            return currentIndex < t;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E element = data[currentIndex];
            currentIndex++;
            return element;
        }
    }

}