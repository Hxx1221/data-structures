package com.hxx.queue;

public interface Queue<E> {
    void enqueue(E e);

    boolean isEmpty();

    int getSize();

    E dequeue();

    E getFront();
}
