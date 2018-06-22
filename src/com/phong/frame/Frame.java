package com.phong.frame;

import com.phong.graphics.Screen;

import javax.swing.*;
import java.awt.*;

public class Frame  extends JFrame {
    public  Frame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Snake");
        setResizable(false);
        setBackground(Color.DARK_GRAY);
        init();
    }
    public  Frame(int size, int maxTicks, int perScore){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Snake");
        setResizable(false);
        setBackground(Color.DARK_GRAY);
        init(size,  maxTicks,  perScore);
    }

    public void init(){
        setLayout(new GridLayout(1, 1, 0 ,0));
        Screen s = new Screen();
        add(s);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void init(int size, int maxTicks, int perScore){
        setLayout(new GridLayout(1, 1, 0 ,0));
        Screen s = new Screen( size,  maxTicks,  perScore);
        add(s);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
