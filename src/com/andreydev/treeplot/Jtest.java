package com.andreydev.treeplot;

/**
 * Created with IntelliJ IDEA.
 * User: sosnov
 * Date: 10.07.13
 * Time: 12:58
 * To change this template use File | Settings | File Templates.
 */
/*
import java.awt.*;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Robot;
import java.awt.Rectangle;
import java.io.IOException;


public class Jtest extends javax.swing.JPanel {
    private String str;
    public Jtest(String str){
        this.str=str;
    }
    @Override
    public void paintComponent(Graphics g) {
        // Draw Tree Here
        g.drawOval(300, 300, 50, 50);
        g.setColor(Color.red);
        g.drawString(str,300+13,300+25);
        g.fillOval(100,100,25,25);
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        BufferedImage screenShot = robot.createScreenCapture(this.getBounds());
        try {
            ImageIO.write(screenShot, "JPG", new File("screenShot.jpg"));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    public static void main(String[] args) throws Exception{
        JFrame jFrame = new JFrame();
        jFrame.add(new Jtest("test"));
        jFrame.setSize(500, 500);
        jFrame.setVisible(true);

    }



}
    */
