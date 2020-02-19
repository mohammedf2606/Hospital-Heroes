package com.hummer.educationalgame.foodminigame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Bowl {
    private Bitmap bowlImage;//bowl later
    private int mX;
    private int mY;
    private int mRadius;

    public int getX() {
        return mX;
    }

    public int getY() {
        return mY;
    }


    public Bowl(Bitmap bowlImage, int viewWidth, int viewHeight) {
        this.bowlImage = bowlImage;
        mX = viewWidth / 2;
        mY = (viewHeight * 4) / 5;
    }

    public void update(int newX, int newY) {
        mX = newX;
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(bowlImage, mX, mY, null);
    }

}
