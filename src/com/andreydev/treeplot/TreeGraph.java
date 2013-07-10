package com.andreydev.treeplot;

import com.andreydev.rbtree.RBNode;
import com.andreydev.rbtree.RBTree;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.*;

/**
 * Created with IntelliJ IDEA.
 * User: sosnov
 * Date: 10.07.13
 * Time: 17:05
 * To change this template use File | Settings | File Templates.
 */

public class TreeGraph extends JFrame {
    private int height, width;
    private Graphics2D window;
    private int branchLine;
    private int offY;
    private int ovalSize;
    private RBTree tree;

    @Override
    public void paint(Graphics g) {
        resize();
        drawTree(tree);
    }

    public TreeGraph(RBTree tree) {
        this.tree = tree;
        this.height = 1000;
        this.width = 1000;
        this.setBounds((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - this.width / 2
                , (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - this.height / 2, this.width, this.height);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window = (Graphics2D) this.getGraphics();
        window.setColor(black);
        window.fillRect(0, 0, height, width);
        window.setColor(red);
        //this.setResizable(false);
        try {
            Thread.sleep(500);
        } catch (Exception e) {
        }
    }

    public void resize() {
        this.width = this.getWidth();
        this.height = this.getHeight();
        ovalSize = (int) (width / (Math.pow(2, 4) * 2 * 2));
        offY = width / tree.getDeep();
        branchLine = width / 4 / tree.getDeep();
        window.setFont(new Font("Ariel", Font.BOLD, ovalSize / 3));
        window.setStroke(new BasicStroke(ovalSize / 10));

    }


    public void drawTree(RBTree tree) {
//         resize();
        window.setColor(white);
        if (tree.getRoot() != tree.getNil()) {
            window.fillRect(0, 0, width, height);
            drawNode(tree.getRoot(), 0, 0, width);

        }
    }

    private void drawNode(RBNode node, int curLevel, int leftPos, int rightPos) {
        if (node == null) return;
        // try{Thread.sleep(100);} catch(Exception e) {}
        if (node.getColor() == com.andreydev.rbtree.Color.BLACK) {
            window.setColor(black);
        } else {
            window.setColor(red);
        }
        window.fillOval(((leftPos + rightPos) / 2) - ovalSize / 2, offY + (curLevel * branchLine) - ovalSize / 2, (int) ovalSize, (int) ovalSize);
        window.setColor(white);
        if (node.getKey() != Integer.MAX_VALUE) {
            window.drawString(node.getKey() + "", ((leftPos + rightPos) / 2) - ovalSize / 6, offY + (curLevel * branchLine) + ovalSize / 8);
        } else {
            window.drawString("NIL", ((leftPos + rightPos) / 2) - ovalSize / 4, offY + (curLevel * branchLine) + ovalSize / 8);
        }

        window.setColor(black);
        if (node.getLeft() != null) {
            window.drawLine(((leftPos + rightPos) / 2), offY + ovalSize / 2 + (curLevel * branchLine),
                    ((3 * leftPos + rightPos) / 4), offY + (curLevel * branchLine + branchLine));
            drawNode(node.getLeft(), curLevel + 1, leftPos, (leftPos + rightPos) / 2);
        }
        if (node.getRight() != null) {
            window.drawLine((leftPos + rightPos) / 2, offY + ovalSize / 2 + (curLevel * branchLine),
                    ((3 * rightPos + leftPos) / 4), offY + (curLevel * branchLine + branchLine));
            drawNode(node.getRight(), curLevel + 1, (leftPos + rightPos) / 2, rightPos);
        }
    }

    public void saveImg() {

    }


}


