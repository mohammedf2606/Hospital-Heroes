package com.hummer.educationalgame.foodminigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import static com.hummer.educationalgame.foodminigame.MainThread.canvas;

public class FoodSprite {

    private Bitmap hashBrown;
    private Bitmap beans;
    private int X, Y;
    private int xVelocity = 10;
    private int yVelocity = 5;
    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

    public FoodSprite(Bitmap hashBrown, Bitmap beans) {
        this.hashBrown = hashBrown;
        this.beans = beans;
        X = 50;
        Y = 0;
    }

    public void drawHashBrown(Canvas canvas) {
        canvas.drawBitmap(hashBrown, X, Y, null);
    }
    public void drawBeans(Canvas canvas) {
        canvas.drawBitmap(beans, 800, Y, null);
    }

    public void update() {
  //      Y++;

 //       X +=xVelocity;
        Y +=yVelocity;
//        if ((X > screenWidth - hashBrown.getWidth()) || (X < 0)) {
//            xVelocity = xVelocity * -1;
//        }
        if ((Y > screenHeight - hashBrown.getHeight()) || (Y < 0)) {
            yVelocity = yVelocity * -1;
        }
    }
}

