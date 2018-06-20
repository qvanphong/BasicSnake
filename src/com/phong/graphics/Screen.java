package com.phong.graphics;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class Screen extends JPanel implements Runnable{
    private final int WIDTH = 480, HEIGHT = 480;
    private Thread thread;
    private boolean running = false;


    public Screen(){
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        start();
    }

    public void tick(){
        System.out.println("Ticking ");
    }

    @Override
    public void paint(Graphics g) {
//        super.paint(g);

    }

    public void start(){
        running = true;
        thread = new Thread(this, "Game Loop");
        thread.start();

    }

    public void stop(){

    }

    public void run(){
        while (running){
            tick();
            repaint();
        }
    }



}
