package com.hummer.hospital_heroes.food_minigame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.hummer.hospital_heroes.Constants;

import java.util.Random;

/**
 * FoodSprite handles the internal logic for the food's position and drawing
 *
 * @author Manav Parikh
 * @version 1.0
 */

class FoodSprite {

    private Bitmap food;
    private int X, Y;
    private int speed = 6;
    Random rand = new Random();

    /**
     * The constructor for the class 'FoodSprite'
     * @param foodImg The bitmap containing an image of the bowl
     * @param delay Determines whether to delay the drop of this sprite
     */
    FoodSprite(Bitmap foodImg, boolean delay) {
        this.food = foodImg;
        X = rand.nextInt(Constants.SCREEN_WIDTH - 100);
        Y = 0;
        if (delay) Y = -300;
    }

    /**
     * Draw the food on the given canvas
     *
     * @param canvas the canvas to draw to
     */
    void drawFood(Canvas canvas) {
        canvas.drawBitmap(food, X, Y, null);
    }

    /**
     * Update the position of the bowl with the given arguments
     *
     * @param bowlX the X position of the bowl
     * @param bowlY the Y position of the bowl
     */
    void update(int bowlX, int bowlY) {
        Y += speed;
        if ((Y > bowlY && Y < bowlY + 150) && (X > bowlX && X < bowlX + 250)) {
            GameView.score++;
            X = rand.nextInt(Constants.SCREEN_WIDTH - 100);
            Y = -90;
        }
        else if(Y >= Constants.SCREEN_HEIGHT){
            X = rand.nextInt(Constants.SCREEN_WIDTH - 100);
            Y = -60;
        }
     }
 }


