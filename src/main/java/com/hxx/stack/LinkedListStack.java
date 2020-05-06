package com.hxx.stack;

import com.hxx.linked.LinkedList;

public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;
    public LinkedListStack(){
        list=new LinkedList<E>();
    }

    public int getSize() {
        return list.getSize();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(E e) {
        list.addFirst(e);
    }

    public E pop() {
        return list.removeFirst();
    }

    public E peek() {
        return list.getFirst();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Stack: top ");
        stringBuilder.append(list);
        return  stringBuilder.toString();
    }
}
