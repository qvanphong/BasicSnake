package com.phong.enities;

import java.awt.*;

public class BodyPart {
    private int xCoor, yCoor, height, width;

    public BodyPart(int xCoor, int yCoor, int tileSize){
        //Tile means a size of square.
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        width = tileSize;
        height = tileSize;

    }

    public void tick(){

    }

    public void draw(Graphics g){
        //Draw snake's bodypart
        //Outline
        g.setColor(Color.BLACK);
        g.fillRect(xCoor * width, yCoor * height, width, height);
        //Green inside
        g.setColor(Color.GREEN);
        g.fillRect(xCoor * width + 2, yCoor * height + 2, width - 4 , height - 4);
    }

    public int getxCoor() {
        return xCoor;
    }

    public void setxCoor(int xCoor) {
        this.xCoor = xCoor;
    }

    public int getyCoor() {
        return yCoor;
    }

    public void setyCoor(int yCoor) {
        this.yCoor = yCoor;
    }
}
