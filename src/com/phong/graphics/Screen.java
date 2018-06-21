package com.phong.graphics;

import com.phong.enities.Apple;
import com.phong.enities.BodyPart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 */
public class Screen extends JPanel implements Runnable{
    private final int WIDTH = 480, HEIGHT = 480;
    private Thread thread;
    private boolean running = false;

    private BodyPart b;
    private ArrayList<BodyPart> snake;

    private int xCoor = 10, yCoor = 10, size = 5;

    private boolean right = true, left = false, up = false, down = false;

    private Random r;
    private int ticks = 0;

    private Key key;

    private Apple apple;
    private ArrayList<Apple> apples;

    public Screen(){
        setFocusable(true);
        key = new Key();
        addKeyListener(key);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        snake = new ArrayList<BodyPart>();
        apples = new ArrayList<Apple>();
        r = new Random();
        start();
    }

    public void tick(){
//        System.out.println("Ticking ");
        if(snake.size() == 0 ){
            b = new BodyPart(xCoor, yCoor, 10);
            snake.add(b);
        }
        if(apples.size()==0){
            int xCoor = r.nextInt(47);
            int yCoor = r.nextInt(47);

            apple = new Apple(xCoor,yCoor,10);
            apples.add(apple);
        }

        for(int i = 0; i < apples.size(); i++){
            if(xCoor == apples.get(i).getxCoor() && yCoor == apples.get(i).getyCoor()){
                size++;
                apples.remove(i);
                i--;
            }
        }

        ticks++;
        if(ticks > 250000){
            if(right) xCoor++;
            if(left) xCoor--;
            if(up) yCoor--;
            if(down) yCoor++;
            ticks = 0;
            b = new BodyPart(xCoor, yCoor, 10);
            snake.add(b);

            if(snake.size() > size){
                snake.remove(0);
            }
        }

    }

    @Override
    public void paint(Graphics g) {
        g.clearRect(0,0,WIDTH, HEIGHT);
        g.setColor(new Color(10, 50, 0));
g.fillRect(0,0, WIDTH,HEIGHT);
//        super.paint(g);
        g.setColor(Color.black);
        for(int i = 0; i < WIDTH / 10; i++){
            g.drawLine(i * 10, 0 , i*10, HEIGHT);
            //x1 va y1 la toa do thu nhat
            //x2 va y2 la toa do thu hai
            //phuong thuc ve duong thang tu toa do thu nhat -> toa do thu hai
        }
        for(int i = 0; i < HEIGHT / 10; i++){
            g.drawLine(0, i * 10, WIDTH, i*10);
        }

        for(int i = 0; i < snake.size(); i++){
            snake.get(i).draw(g);
        }
        for(int i = 0; i < apples.size(); i++) {
            apples.get(i).draw(g);
        }
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

    private class Key implements KeyListener{
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if(key == KeyEvent.VK_RIGHT && !left){
                up=false;
                down = false;
                right = true;
            }if(key == KeyEvent.VK_LEFT && !right){
                up=false;
                down = false;
                left = true;
            }if(key == KeyEvent.VK_UP && !down){
                up=true;
                left = false;
                right = false;
            }if(key == KeyEvent.VK_DOWN && !up){
                left=false;
                down = true;
                right = false;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }



}
