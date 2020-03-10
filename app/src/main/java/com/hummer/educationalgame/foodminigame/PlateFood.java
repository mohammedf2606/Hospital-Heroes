package com.hummer.educationalgame.foodminigame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.hummer.educationalgame.Constants;

import java.util.Random;

class PlateFood {
    private int X, Y;
    private int left, top, right, bottom;
    private int stage;
    private Bitmap food;
    private Paint paint;


    PlateFood(Bitmap foodImg) {
        Y = 0;
        X = 0;
        this.food = foodImg;
        food.setHeight(500);
        food.setWidth(500);
        paint = new Paint();
        paint.setColor(Color.GRAY);

        left = 0;
        top = 0;
        right = 500;
        bottom = 500;
    }

    void drawFood(Canvas canvas) {
        canvas.drawBitmap(food, X, Y, null);
        canvas.drawArc(left,top,right,bottom, 0F, 90F, true, paint);

    }

    void update() {
        Y++;

    }
 }


