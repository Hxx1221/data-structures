package com.hxx.queue;

import com.hxx.array.Array;

public class ArrayQueue<E> implements  Queue<E> {
    private Array<E> array;

    public ArrayQueue(int capacity){
        array = new Array<E>(capacity);
    }
    public ArrayQueue(){
        array = new Array<E>();
    }
    public void enqueue(E o) {
         array.addLast(o);
    }
    public int getCapacity() {
        return array.getCapacity();
    }
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getSize() {
        return array.getSize();
    }

    public E dequeue() {
        return array.removeFirst();
    }

    public E getFront() {
        return array.getFirst();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Queue: ");
        stringBuilder.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            stringBuilder.append(array.get(i));
            if (i != array.getSize() - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("] tail");
        return  stringBuilder.toString();
    }
}
