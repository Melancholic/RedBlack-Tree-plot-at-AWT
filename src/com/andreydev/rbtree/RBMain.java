package com.andreydev.rbtree;

import com.andreydev.treeplot.TreeGraph;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class RBMain {
    public static void main(String args[]) {
        double t0 = System.currentTimeMillis();
        RBNode nil = new RBNode(Color.BLACK);
        RBTree tree = new RBTree(nil);
        tree.insert(10);
        tree.insert(85);
        tree.insert(15);
        tree.insert(70);
        tree.insert(20);
        tree.insert(60);
        tree.insert(30);
        tree.insert(50);
        tree.insert(65);
        tree.insert(80);
        tree.insert(90);
        tree.insert(40);
        tree.insert(5);
        tree.insert(55);
        tree.makeDotFile();
        System.out.println("min: " + tree.getMin() + " max: " + tree.getMax());
        System.out.println("Deep:  " + tree.getDeep());
        final TreeGraph a = new TreeGraph(tree);
        a.addComponentListener(new ComponentListener() {

            public void componentResized(ComponentEvent e) {
                int SIZE = 10;
                if ((a.getWidth() % SIZE != 0) || (a.getHeight() % SIZE != 0)) {
                    int screenWidth = ((a.getWidth() + SIZE) / SIZE) * SIZE;
                    int screenHeight = ((a.getHeight() + SIZE) / SIZE) * SIZE;
                    a.setSize(screenWidth, screenHeight);
                    a.resize();
                }
            }

            public void componentHidden(ComponentEvent arg0) {
            }

            public void componentMoved(ComponentEvent arg0) {
            }

            public void componentShown(ComponentEvent arg0) {
            }
        });

    }

}