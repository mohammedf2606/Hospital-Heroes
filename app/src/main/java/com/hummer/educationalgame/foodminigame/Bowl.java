package com.hummer.educationalgame.foodminigame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

class Bowl {
    private Bitmap bowlImage;//bowl later
    private int mX;
    private int mY;
    private int mRadius;

    int getX() {
        return mX;
    }

    int getY() {
        return mY;
    }


    Bowl(Bitmap bowlImage, int viewWidth, int viewHeight) {
        this.bowlImage = bowlImage;
        mX = viewWidth / 2;
        mY = viewHeight - 166;
//        mX =1;
//        mY = 2;
    }

    void update(int newX, int newY) {
        mX = newX;
    }

    void draw(Canvas canvas){
        canvas.drawBitmap(bowlImage, mX, mY, null);
    }

}
