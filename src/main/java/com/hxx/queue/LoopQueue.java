package com.hxx.queue;


public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;

    private int size;

    public LoopQueue(int capacity) {

        data = (E[]) new Object[capacity + 1];

        front = 0;
        tail = 0;
        size = 0;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    public LoopQueue() {
        this(10);
    }

    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 1);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int i) {
        E[] newData = (E[]) new Object[i + 1];
        for (int j = 0; j < data.length; j++) {
            newData[j] = data[(j + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    public boolean isEmpty() {
        return front == tail;
    }

    public int getSize() {
        return size;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("dequeue");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("getFront");
        }
        return data[front];
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("LoopQueue: size = %d , capacity = %d\n", size, data.length-1));
        stringBuffer.append("front [");
        for (int i = front; i !=tail ; i=(i+1)%data.length) {
            stringBuffer.append(data[i]);
            if ((i+1) % data.length != tail) {
                stringBuffer.append(",");
            }
        }
        stringBuffer.append("] tail");
        return stringBuffer.toString();
    }
}
