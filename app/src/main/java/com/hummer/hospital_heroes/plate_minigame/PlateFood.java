package com.hummer.hospital_heroes.plate_minigame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.hummer.hospital_heroes.Constants;

/**
 * Handles the internal logic for the states of the plate mini game.
 *
 * @author Manav Parikh
 * @version 1.0
 */
class PlateFood {
    private int X, Y;
    private Bitmap food0, food1, food2, food3, food4;
    private int state = 0;


    PlateFood(Bitmap img0, Bitmap img1, Bitmap img2, Bitmap img3, Bitmap img4) {
        Y = Constants.SCREEN_HEIGHT/2 - 200;
        X = Constants.SCREEN_WIDTH/2 - 200;
        this.food0 = Bitmap.createScaledBitmap(img0, 400, 400, false);
        this.food1 = Bitmap.createScaledBitmap(img1, 400, 400, false);
        this.food2 = Bitmap.createScaledBitmap(img2, 400, 400, false);
        this.food3 = Bitmap.createScaledBitmap(img3, 400, 400, false);
        this.food4 = Bitmap.createScaledBitmap(img4, 400, 400, false);
    }

    /**
     * Draws food based on the current state
     * @param canvas The canvas to draw on
     */
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


