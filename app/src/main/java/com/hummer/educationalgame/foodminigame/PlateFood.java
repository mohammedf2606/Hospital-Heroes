package com.hummer.educationalgame.foodminigame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.hummer.educationalgame.Constants;

import java.util.Random;

class PlateFood {
    private int X, Y;
    private Bitmap food0, food1, food2, food3, food4;
    private int state = 0;


    PlateFood(Bitmap food0, Bitmap food1, Bitmap food2, Bitmap food3, Bitmap food4) {
        Y = Constants.SCREEN_HEIGHT/2 - 200;
        X = Constants.SCREEN_WIDTH/2 - 200;
        this.food0 = Bitmap.createScaledBitmap(food0, 400, 400, false);
        this.food1 = Bitmap.createScaledBitmap(food1, 400, 400, false);
        this.food2 = Bitmap.createScaledBitmap(food2, 400, 400, false);
        this.food3 = Bitmap.createScaledBitmap(food3, 400, 400, false);
        this.food4 = Bitmap.createScaledBitmap(food4, 400, 400, false);
    }

    boolean drawFood(Canvas canvas) {
        switch (state) {
            case 0:
                canvas.drawBitmap(food0, X, Y, null);
                break;
            case 1:
                canvas.drawBitmap(food1, X, Y, null);
                break;
            case 2:
                canvas.drawBitmap(food2, X, Y, null);
                break;
            case 3:
                canvas.drawBitmap(food3, X, Y, null);
                break;
            case 4:
                canvas.drawBitmap(food4, X, Y, null);
                break;
            default:
                return true;
        }
        return false;
    }

    void update() {
        state++;
    }
 }


