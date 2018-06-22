package com.phong.graphics;

import com.phong.enities.Apple;
import com.phong.enities.BodyPart;
import com.phong.frame.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 */
public class Screen extends JPanel implements Runnable {


    private final int GAME_WIDTH = 480, GAME_HEIGHT = 480;      //Game Panel Size WxH
    private final int WIDTH = 600, HEIGHT = 480;                //Window Size
    private Thread thread;
    private boolean running = false;

    private int score = 0;
    private int perScore = 1;

    private ArrayList<Integer> defaultValues;                   //This to save the default values when user play with customize match
    private int[] highscores = new int[5];

    private BodyPart b;
    private ArrayList<BodyPart> snake;

    private Apple apple;
    private ArrayList<Apple> apples;

    private int xCoor = 10, yCoor = 10, size = 5;

    private boolean right = true, left = false, up = false, down = false;


    private int ticks = 0;
    private int maxTicks = 250000;

    private Key key;

    private Random r;


    public Screen(int size, int maxTicks, int perScore){

        setFocusable(true);
        key = new Key();
        addKeyListener(key);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        snake = new ArrayList<>();
        apples = new ArrayList<>();
        r = new Random();
        defaultValues = new ArrayList<>();
        this.size = size;
        this.maxTicks = maxTicks;
        this.perScore = perScore;
        saveDefaultValues();
        for(int i = 0; i < highscores.length;i++){
            highscores[i] = 0;
        }
        start();
    }


    public Screen() {
        defaultValues = new ArrayList<>();
        saveDefaultValues();
        for(int i = 0; i < highscores.length;i++){
            highscores[i] = 0;
        }
        setFocusable(true);
        key = new Key();
        addKeyListener(key);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        snake = new ArrayList<>();
        apples = new ArrayList<>();

        r = new Random();
        start();
    }

    private boolean saveDefaultValues(){
        defaultValues.add(size);
        defaultValues.add(maxTicks);
        defaultValues.add(perScore);
        return true;
    }

    private boolean setDefaultValues(){
        size = defaultValues.get(0);
        maxTicks = defaultValues.get(1);
        perScore = defaultValues.get(2);
        return true;
    }

    private void tick() {
        //Generate Snake
        if (snake.size() == 0) {
            b = new BodyPart(xCoor, yCoor, 10);
            snake.add(b);
        }
        //Generate Apple
        if (apples.size() == 0) {
            int xCoor = 0, yCoor = 0;
            //Finding game mode then generate with compatible situation
            switch (MainFrame.gamemode) {
                case 0:
                    xCoor = r.nextInt(46) + 1;
                    yCoor = r.nextInt(46) + 1;
                    break;
                case 1:
                    xCoor = r.nextInt(47);
                    yCoor = r.nextInt(47);
                    break;
            }
            //New Apple
            apple = new Apple(xCoor, yCoor, 10);
            apples.add(apple);
        }

        //Checking did snake eat the apple
        for (int i = 0; i < apples.size(); i++) {
            if (xCoor == apples.get(i).getxCoor() && yCoor == apples.get(i).getyCoor()) {
                size++;
                score+= perScore;
                apples.remove(i);
                i--;
            }
        }

        //Ticks mean speed.
        ticks++;

        if (ticks > maxTicks) {
            if (right) xCoor++;
            if (left) xCoor--;
            if (up) yCoor--;
            if (down) yCoor++;
            //Debug
//            for (int i = 0; i < snake.size(); i++) {
//                System.out.print("X" + i + ": " + snake.get(i).getxCoor() + " Y" + i + ": " + snake.get(i).getyCoor() + "   ");
//            }
//            System.out.println();
            //Finding game mode to decide what happen when snake touch the wall
            switch (MainFrame.gamemode) {
                case 0:
                    if (xCoor < 1 || xCoor > 46 || yCoor < 1 || yCoor > 46) stop();
                    break;
                case 1:
                    if (xCoor < 0) xCoor = 47;
                    if (xCoor > 47) xCoor = 0;
                    if (yCoor < 0) yCoor = 47;
                    if (yCoor > 47) yCoor = 0;
                    break;
            }

            ticks = 0;
            b = new BodyPart(xCoor, yCoor, 10);
            snake.add(b);

            if (snake.size() > size) {
                snake.remove(0);
            }
        }
        for (int i = 0; i < snake.size(); i++) {

            if (xCoor == snake.get(i).getxCoor() && yCoor == snake.get(i).getyCoor()) {
                if (i != snake.size() - 1)
                    // Chu yeu de check o phan dau, khi khoi tao xCoor, yCoor cua snake = voi vi tri dau tien trong snake(arrayList)
                    // neu i khong bang (size - 1) thi skip
                    stop();
            }
        }
    }
    private void sortHighScore(){
        for (int i = 0; i < highscores.length -1; i++) {
            for (int j = i+1; j < highscores.length ; j++) {
                if (highscores[i] < highscores[j]) {
                    int temp = highscores[i];
                    highscores[i] = highscores[j];
                    highscores[j] = temp;
                }
            }
        }

    }
    private boolean findHighScore(int score){
//        for(int i = 0; i < highscores.length; i++){
//            if( score <= highscores[i]) {
//                return false;
//            }
//        }
        //Find lowest
        int lowest = 0;
        for(int i = 0; i < highscores.length; i++){
            for(int j = i+1; j < highscores.length;j++) {
                if (highscores[i] < highscores[j]) {
                    lowest = highscores[i];
                }else if(highscores[j] < highscores[i]){
                    lowest = highscores[j];
                }
            }
        }
        System.out.println(lowest);
        if(lowest < score){
            for(int i = 0; i < highscores.length; i++){
                if(highscores[i] == lowest) {
                    highscores[i] = score;
                    sortHighScore();
                    return true;
                }
            }
        }


        return false;
    }
    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, GAME_WIDTH, GAME_HEIGHT);

        //Score Panel.
        g.setColor(Color.DARK_GRAY);
        g.fillRect(520, 210, 50, 50);
        g.setColor(Color.WHITE);
        g.drawString("Score: ", 525, 200);
        g.drawString(score + "", 535, 220);
        g.setColor(new Color(10, 50, 0));
        g.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);

        //High Score Panel
        g.setColor(Color.DARK_GRAY);
        g.fillRect(500, 300, 150, 200);
        g.setColor(Color.WHITE);
        g.drawString("High Scores: ", 510, 300);
        int heightOfScore = 315;
        for(int i = 0; i < highscores.length; i++){
            g.drawString((i+1)+". "+highscores[i],510,heightOfScore);
            heightOfScore+=15;
        }

        //Generate Grid
        g.setColor(Color.black);
        for (int i = 0; i < GAME_WIDTH / 10; i++) {
            g.drawLine(i * 10, 0, i * 10, GAME_HEIGHT);
            //x1 va y1 la toa do thu nhat
            //x2 va y2 la toa do thu hai
            //phuong thuc ve duong thang tu toa do thu nhat -> toa do thu hai
        }
        for (int i = 0; i < GAME_HEIGHT / 10; i++) {
            g.drawLine(0, i * 10, GAME_WIDTH, i * 10);
        }
        //If game mode is 0 so generate the wall, else do nothing.
        if (MainFrame.gamemode == 0) {
            g.setColor(Color.gray);
            g.fillRect(0, 0, GAME_WIDTH, 11);
            g.fillRect(0, 470, GAME_WIDTH, 11);
            g.fillRect(0, 0, 11, GAME_HEIGHT);
            g.fillRect(470, 0, 11, GAME_HEIGHT);
        }
        //Draw the snake
        for (int i = 0; i < snake.size(); i++) {
            snake.get(i).draw(g);
        }
        for (Apple apple1 : apples) {
            apple1.draw(g);
        }
    }

    private void start() {
        running = true;
        thread = new Thread(this, "Game Loop");
        thread.start();

    }
    //Create this to make the game's values back to default when snake touched his tail or wall.
    private void reset() {
        xCoor = 10;
        yCoor = 10;
        setDefaultValues();
        score = 0;
        right = true;
        left = false;
        up = false;
        down = false;
        ticks = 0;
        snake = new ArrayList<>();
        apples = new ArrayList<>();
        b = null;
    }

    public void stop() {
        running = false;
        System.out.println("Stopped");
        try {
            //Save the score
            findHighScore(score);
            //Wait to stop in 1.5s

            thread.join(1500);

            reset();
            running = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (running) {
            tick();
            repaint();
        }
    }

    private class Key implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_RIGHT && !left) {
                up = false;
                down = false;
                right = true;
                try {
                    thread.sleep(50);
                }catch (Exception ee){}
            }
            if (key == KeyEvent.VK_LEFT && !right) {
                up = false;
                down = false;
                left = true;
                try {
                    thread.sleep(50);
                }catch (Exception ee){}
            }
            if (key == KeyEvent.VK_UP && !down) {
                up = true;
                left = false;
                right = false;
                try {
                    thread.sleep(50);
                }catch (Exception ee){}
            }
            if (key == KeyEvent.VK_DOWN && !up) {
                left = false;
                down = true;
                right = false;
                try {
                    thread.sleep(50);
                }catch (Exception ee){}

            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }


}
