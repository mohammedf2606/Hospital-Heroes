package com.hummer.educationalgame.foodminigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.hummer.educationalgame.Constants;

import static com.hummer.educationalgame.foodminigame.MainThread.canvas;

class FoodSprite {

    private Bitmap hashBrown;
    private Bitmap beans;
    private int X, Y, X1;
    private int xVelocity = 10;
    private int yVelocity = 5;

    FoodSprite(Bitmap hashBrown, Bitmap beans) {
        this.hashBrown = hashBrown;
        this.beans = beans;
        X = 50;
        Y = 0;
        X1 = 100;
    }

    int getX() {
        return X;
    }

    void drawHashBrown(Canvas canvas) {
        canvas.drawBitmap(hashBrown, X, Y, null);
    }
    void drawBeans(Canvas canvas) {
        canvas.drawBitmap(beans, X1, Y, null);
    }

    void update(int bowlX) {
        Y++;
        if(Y == 610){
            double randomFactor = Math.random();
            X = (int) randomFactor * 1024;
            Y = -40;
        }
     }
 }


