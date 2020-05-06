package com.hxx.bst;

public class Main {

    public static void main(String[] args) {


        BST<Integer> integerBST = new BST<Integer>();
        int[] nums = {5,3, 6, 8, 4, 2};

        for (int num :
                nums) {
            integerBST.add(num);
        }
        integerBST.preOrder();
        System.out.println("=====");
        integerBST.inOrder();
        System.out.println("=====");
        integerBST.postOrder();
        System.out.println("=====");
        integerBST.levelOrder();
    }


}
