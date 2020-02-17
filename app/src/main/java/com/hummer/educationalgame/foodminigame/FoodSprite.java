package com.hummer.educationalgame.foodminigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class FoodSprite {

    private Bitmap hashBrown;
    private int X,Y;
    private int xVelocity = 10;
    private int yVelocity = 5;
    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

    public FoodSprite(Bitmap hashBrown){
        this.hashBrown = hashBrown;
        X = 100;
        Y = 100;
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(hashBrown, X, Y, null);
    }

    public void update(){
        X +=xVelocity;
        Y +=yVelocity;
        if((X > screenWidth - hashBrown.getWidth()) || (X <0)){
            xVelocity = xVelocity*-1;
        }
        if((X > screenHeight - hashBrown.getHeight()) || (X <0)){
            yVelocity = yVelocity*-1;
        }
    }
}
