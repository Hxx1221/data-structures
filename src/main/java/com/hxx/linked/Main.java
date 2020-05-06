package com.hxx.linked;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> objectLinkedList = new LinkedList<Integer>();


        for (int i = 0; i < 5; i++) {
            objectLinkedList.addFirst(i);
            System.out.println(objectLinkedList);
        }
        objectLinkedList.add(2,888);
        System.out.println(objectLinkedList);
        objectLinkedList.remove(2);
        System.out.println(objectLinkedList);

        objectLinkedList.removeFirst();
        System.out.println(objectLinkedList);
        objectLinkedList.removeLast();
        System.out.println(objectLinkedList);
    }
}
