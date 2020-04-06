package com.hummer.hospital_heroes.milk_minigame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.hummer.hospital_heroes.Constants;

import java.util.Random;

class MilkCarton {

    private Bitmap carton;
    private Bitmap droplet;
    private int X, Y, cX, cY;
    Random rand = new Random();
    int speed = 6;
    boolean goRight = true;
    int timeToDrop = 0;


    MilkCarton(Bitmap milk2, Bitmap milk) {
        this.carton = Bitmap.createScaledBitmap(milk2, 170,150, false);
        this.droplet = Bitmap.createScaledBitmap(milk, 120,120, false);
        X = rand.nextInt(Constants.SCREEN_WIDTH - 100);
        Y = 0;
        cX = 0;
        cY = -20;
    }

    int getX() {
        return X;
    }

    void drawFood(Canvas canvas) {
        canvas.drawBitmap(carton, cX, cY, null);
        canvas.drawBitmap(droplet, X, Y, null);
    }

    void update(int bowlX, int bowlY) {
        if (timeToDrop == 0) {
            X = cX;
            Y = 10;
            timeToDrop = -1;
        }
        Y += speed;
        if(goRight) {
            cX += 4;
            if (cX > Constants.SCREEN_WIDTH - 100) goRight = false;
        }
        else {
            cX -= 4;
            if (cX < 0) goRight = true;
        }
        if ((Y > bowlY && Y < bowlY + 150) && (X > bowlX && X < bowlX + 250)) {
            MilkGameView.score++;
            System.out.println("Score: "+MilkGameView.score);
            Y = 1000;
            timeToDrop = rand.nextInt(60) + 1;

        }
        else if(Y >= Constants.SCREEN_HEIGHT){
            Y = 1000;
            timeToDrop = rand.nextInt(60) + 1;
        }
        timeToDrop--;
    }
 }


