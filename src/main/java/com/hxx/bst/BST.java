package com.hxx.bst;

import java.util.LinkedList;
import java.util.Stack;

public class BST<E extends Comparable<E>> {

    private class Node {

        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    //添加元素e
    public void add(E e) {
//        if (root == null) {
//            root = new Node(e);
//            size++;
//        } else {
        root = add(root, e);
        //       }
    }

    //添加元素e
    public void add1(Node node, E e) {
        if (node.e.equals(e)) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }
        if (e.compareTo(node.e) < 0) {
            add(node.left, e);
        } else {
            add(node.right, e);
        }
    }

    //添加元素e
    public Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);

    }

    private boolean contains(Node node, E e) {
        if (root == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    //前序遍历
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //中序遍历
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //后序遍历
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        generateBSTString(root, 0, stringBuilder);
        return stringBuilder.toString();

    }

    private void generateBSTString(Node node, int i, StringBuilder stringBuilder) {
        if (node == null) {
            stringBuilder.append(generateDepthString(i) + "null\n");
            return;
        }
        stringBuilder.append(generateDepthString(i) + node.e + "\n");
        generateBSTString(node.left, i + 1, stringBuilder);
        generateBSTString(node.right, i + 1, stringBuilder);
    }

    private String generateDepthString(int i) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < i; j++) {
            stringBuilder.append("--");
        }
        return stringBuilder.toString();
    }

    //非递归方式 前序遍历 栈
    public void preOrderNR() {
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            System.out.println(pop.e);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    //层序遍历  队列
    public void levelOrder() {
        LinkedList<Node> nodes = new LinkedList<Node>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node remove = nodes.remove();
            System.out.println(remove.e);
            if (remove.left != null) {
                nodes.add(remove.left);
            }
            if (remove.right != null) {
                nodes.add(remove.right);
            }
        }
    }

    public E minimun() {
        if (size == 0) {
            throw new IllegalArgumentException("minimun");
        }
        return minimun(root).e;

    }

    private Node minimun(Node root) {

        if (root.left == null) {
            return root;
        }
        return minimun(root.left);
    }

    public E maximun() {
        if (size == 0) {
            throw new IllegalArgumentException("minimun");
        }
        return maximun(root).e;
    }

    private Node maximun(Node root) {
        if (root.right == null) {
            return root;
        }
        return maximun(root.right);
    }

    public E removeMin() {
        E minimun = minimun();
        root = removeMin(root);
        return minimun;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node right = node.right;
            node.right = null;
            size--;
            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }


    public E removeMax() {
        E maximun = maximun();
        root = removeMax(root);
        return maximun;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node left = node.left;
            node.left = null;
            size--;
            return left;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.left = remove(node.right, e);
            return node;
        } else {
            if (node.left == null) {
                Node right = node.right;
                node.right = null;
                size--;
                return right;
            }
            if (node.right == null) {
                Node left = node.left;
                node.left = null;
                size--;
                return left;
            }
            Node minimun = minimun(node.right);
            minimun.right = removeMin(node.right);
            minimun.left = node.left;
            node.left = node.right = null;
            return minimun;
        }
    }
}
