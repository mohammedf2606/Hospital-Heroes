package com.hummer.educationalgame.foodminigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.hummer.educationalgame.Constants;

import java.util.Random;

import static com.hummer.educationalgame.foodminigame.MainThread.canvas;

class FoodSprite {

    private Bitmap food;
    private int X, Y;
    Random rand = new Random();

    FoodSprite(Bitmap foodImg, boolean delay) {
        this.food = foodImg;
        double randomFactor = Math.random();
        X = rand.nextInt(Constants.SCREEN_WIDTH - 100);
        Y = 0;
        if (delay) Y = -300;
    }

    int getX() {
        return X;
    }

    void drawFood(Canvas canvas) {
        canvas.drawBitmap(food, X, Y, null);
    }

    void update(int bowlX, int bowlY) {
        int speed = 8;
        Y += speed; //SLOW DOWN 250 166
        if ((Y > bowlY && Y < bowlY + 150) && (X > bowlX && X < bowlX + 250)) {
            GameView.score++;
            System.out.println("Score: "+GameView.score);
            X = rand.nextInt(Constants.SCREEN_WIDTH - 100);
            Y = -90;
        }
        else if(Y >= Constants.SCREEN_HEIGHT){
            X = rand.nextInt(Constants.SCREEN_WIDTH - 100);
            Y = -60;
        }
     }
 }


