package com.andreydev.rbtree;

public class RBNode {
    private int key;
    private Color color;
    private RBNode left, right, parrent;

    public RBNode(int key, Color color, RBNode nil) {
        this.key = key;
        this.color = color;
        this.left = nil;
        this.right = nil;
        this.parrent = nil;
    }

    public RBNode(int key, RBNode nil) {
        this.setKey(key);
        this.left = nil;
        this.right = nil;
        this.parrent = nil;
    }

    //Constructor for nil
    public RBNode(Color color) {
        this.color = color;
        key = Integer.MAX_VALUE;
        left = null;
        right = null;
        parrent = null;
    }
  /*
    public void printNode(){
        String n = "NIL";
        String leftString = new Integer(this.left.getKey()).toString();
        String rightString = new Integer(this.right.getKey()).toString();
        String pString = new Integer(this.parrent.getKey()).toString();

        if(this.left.getKey() == Integer.MAX_VALUE){
            leftString = n;
        }
        if(this.right.getKey() == Integer.MAX_VALUE){
            rightString = n;
        }
        if(this.parrent.getKey() == Integer.MAX_VALUE){
            pString = n;
        }


        System.out.printf("Key: %d\nLeft: %s\nRight: %s\nColor: %s\nParent: \n\n", key,
                leftString, rightString, color.toString(), pString);
    }      */

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public RBNode getLeft() {
        return left;
    }

    public void setLeft(RBNode left) {
        this.left = left;
    }

    public RBNode getRight() {
        return right;
    }

    public void setRight(RBNode right) {
        this.right = right;
    }

    public RBNode getParrent() {
        return parrent;
    }

    public void setParrent(RBNode parrent) {
        this.parrent = parrent;
    }
}

