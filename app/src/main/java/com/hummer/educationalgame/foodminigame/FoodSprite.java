package com.hummer.educationalgame.foodminigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.hummer.educationalgame.Constants;

import static com.hummer.educationalgame.foodminigame.MainThread.canvas;

class FoodSprite {

    private Bitmap hashBrown;
    private Bitmap beans;
    private int X, Y;
    private int xVelocity = 10;
    private int yVelocity = 5;

    FoodSprite(Bitmap hashBrown, Bitmap beans) {
        this.hashBrown = hashBrown;
        this.beans = beans;
        X = 50;
        Y = 0;
    }

    int getX() {
        return X;
    }

    void drawHashBrown(Canvas canvas) {
        canvas.drawBitmap(hashBrown, X, Y, null);
    }
    void drawBeans(Canvas canvas) {
        canvas.drawBitmap(beans, 800, Y, null);
    }

    void update(int bowlX) {
  //      Y++;

 //       X +=xVelocity;
        Y +=yVelocity;
//        if ((X > screenWidth - hashBrown.getWidth()) || (X < 0)) {
//            xVelocity = xVelocity * -1;
//        }
        if ((Y > Constants.SCREEN_HEIGHT - hashBrown.getHeight()) || (Y < 0)) {
            yVelocity = yVelocity * -1;
        }
    }
}

