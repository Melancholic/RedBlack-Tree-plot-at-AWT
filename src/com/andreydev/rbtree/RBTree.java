package com.andreydev.rbtree;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class RBTree {
    private RBNode root;
    private RBNode nil;
    private ArrayList<String> treeStr;

    public RBTree() {
        this.nil = new RBNode(Color.BLACK);
        this.root = nil;

    }

    public RBTree(RBNode nil) {
        this.nil = nil;
        this.root = nil;

    }

    private void left_rotate(RBNode x) {
        //  makeDotFile();
        RBNode y = x.getRight();
        x.setRight(y.getLeft());
        if (y.getLeft() != nil) {
            y.getLeft().setParrent(x);
        }
        y.setParrent(x.getParrent());
        if (x.getParrent() == nil) {
            root = y;
        } else {
            if (x == x.getParrent().getLeft()) {
                x.getParrent().setLeft(y);
            } else {
                x.getParrent().setRight(y);
            }
        }
        y.setLeft(x);
        x.setParrent(y);
        // makeDotFile();
    }

    private void right_rotate(RBNode x) {
        //makeDotFile();
        RBNode y = x.getLeft();
        x.setLeft(y.getRight());
        if (y.getRight() != nil) {
            y.getRight().setParrent(x);
        }
        y.setParrent(x.getParrent());
        if (x.getParrent() == nil) {
            root = y;
        } else {
            if (x == x.getParrent().getRight()) {
                x.getParrent().setRight(y);
            } else {
                x.getParrent().setLeft(y);
            }
        }
        y.setRight(x);
        x.setParrent(y);
        //makeDotFile();
    }

    public void insert(int val) {
        rb_insert(new RBNode(val, nil));
    }

    public void rb_insert(RBNode z) {
        RBNode y = nil;
        RBNode x = root;
        //  System.out.println(z.getKey());
        while (x != nil) {
            y = x;
            if (z.getKey() < x.getKey()) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }
        z.setParrent(y);
        //  makeDotFile();
        if (y == nil) {
            root = z;
        } else {
            if (z.getKey() < y.getKey()) {
                y.setLeft(z);
                //  makeDotFile();
            } else {
                y.setRight(z);
                //   makeDotFile();
            }
        }
        z.setLeft(nil);
        z.setRight(nil);
        z.setColor(Color.RED);
        rb_insert_fixup(z);
    }

    private void rb_insert_fixup(RBNode z) {
        //   makeDotFile();
        //   com.andreydev.rbtree.RBNode y;
        RBNode y = nil;
        while (z.getParrent().getColor() == Color.RED) {
            if (z.getParrent() == z.getParrent().getParrent().getLeft()) {
                y = z.getParrent().getParrent().getRight();
                if (y.getColor() == Color.RED) {
                    z.getParrent().setColor(Color.BLACK);
                    y.setColor(Color.BLACK);
                    z.getParrent().getParrent().setColor(Color.RED);
                } else if (z == z.getParrent().getRight()) {
                    z = z.getParrent();
                    left_rotate(z);
                } else {
                    z.getParrent().setColor(Color.BLACK);
                    z.getParrent().getParrent().setColor(Color.RED);
                    right_rotate(z.getParrent().getParrent());
                }
            } else {
                y = z.getParrent().getParrent().getLeft();
                if (y.getColor() == Color.RED) {
                    z.getParrent().setColor(Color.BLACK);
                    y.setColor(Color.BLACK);
                    z.getParrent().getParrent().setColor(Color.RED);
                    z = z.getParrent().getParrent();
                } else if (z == z.getParrent().getLeft()) {
                    z = z.getParrent();
                    right_rotate(z);
                    z.getParrent().setColor(Color.BLACK);
                    z.getParrent().getParrent().setColor(Color.RED);
                    left_rotate(z.getParrent().getParrent());
                } else {
                    z.getParrent().setColor(Color.BLACK);
                    z.getParrent().getParrent().setColor(Color.RED);
                    left_rotate(z.getParrent().getParrent());
                }

            }
        }
        root.setColor(Color.BLACK);
        //  makeDotFile();
    }

    private int getDeep(RBNode node) {
        if (node != nil) {
            int valLeft = getDeep(node.getLeft());
            int valRight = getDeep(node.getRight());
            if (valLeft > valRight) {
                return valLeft + 1;
            } else {
                return valRight + 1;
            }
        } else {
            return 0;
        }
    }

    public int getDeep() {
        RBNode x = root;
        return getDeep(x);
    }
     /*

    public com.andreydev.rbtree.RBNode find(int k)
    {
        com.andreydev.rbtree.RBNode x = root;
        while(x!=nil && x.getKey()!=k)
        {
            if(x.getKey() > k)
            {
                x = x.getLeft();
            }
            else
            {
                x = x.getRight();
            }
        }
        return x;
    }

    public void printTree(com.andreydev.rbtree.RBNode node)
    {
        if(node == nil)
        {
            return;
        }
        printTree(node.getLeft());
        node.printNode();     */
/*System.out.printf("Key: %d\nLeft: %d\nRight: %d\nColor: %s\n\n", node.getKey(), node.getLeft().getKey(),
node.getRight().getKey(), node.getColor().name());*/
   /*     printTree(node.getRight());




    }
     */


    public RBNode getRoot() {
        return root;
    }

    public void setRoot(RBNode root) {
        this.root = root;
    }

    public int getMin() {
        RBNode x = root;
        if (x.getLeft() != nil) {
            do {
                x = x.getLeft();
            } while (x.getLeft() != nil);
        }
        return x.getKey();
    }


    public int getMax() {
        RBNode x = root;
        if (x.getRight() != nil) {
            do {
                x = x.getRight();
            } while (x.getRight() != nil);
        }
        return x.getKey();
    }


    public void makeDotFile() {
        treeStr = new ArrayList<String>();
        //System.out.println("SSS: " + root.getKey());
        treeStr.add(" #This file is automatically generated. Use the bin file.");
        treeStr.add("digraph BinTree{");
        //treeStr.add("dpi=\"300\";");
        // treeStr.add("graph[height=1000, width=1000];");
        runTree(root);
        treeStr.add("}\n");
        String dirName = "./img/";
        String fileName = "tree" + System.currentTimeMillis() + ".dot";
        PrintWriter file;
        try {
            File fileTmp = new File(dirName);
            if (!Files.exists(Paths.get(fileTmp.getPath()))) {
                Files.createDirectories(Paths.get(fileTmp.getPath()));
            }
            fileTmp.createNewFile();
            fileTmp = null;
            file = new PrintWriter(new FileOutputStream(dirName + fileName));
            for (int i = 0; i < treeStr.size(); ++i) {
                file.println(treeStr.get(i));
            }
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }


    private void runTree(RBNode root) {
        if (root != nil) {
            if (root.getColor() == Color.BLACK) {
                treeStr.add(root.getKey() + " [style=filled,color=black,fontcolor=white];");
            } else {
                treeStr.add(root.getKey() + " [style=filled,color=red];");
            }
            runTree(root.getLeft());
            if (root.getLeft() != nil) {
                treeStr.add(root.getKey() + " -> " + root.getLeft().getKey() + ";");
            } else {
                treeStr.add("LNil" + root.getKey() + " [label=\"Nil\"];");
                treeStr.add(root.getKey() + " -> " + "LNil" + root.getKey() + ";");
            }

            if (root.getRight() != nil) {
                treeStr.add(root.getKey() + " -> " + root.getRight().getKey() + ";");
                runTree(root.getRight());
            } else {
                treeStr.add("RNil" + root.getKey() + " [label=\"Nil\"];");
                treeStr.add(root.getKey() + " -> " + "RNil" + root.getKey() + ";");
            }
        } else {
            return;
        }
    }

    public RBNode getNil() {
        return nil;
    }
}

