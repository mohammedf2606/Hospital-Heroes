package com.hummer.hospital_heroes.food_minigame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Bowl handles the internal logic for the bowl's position and drawing
 *
 * @author Manav Parikh
 * @version 1.0
 */

public class Bowl {
    private Bitmap bowlImage;
    private int mX;
    private int mY;

    public int getX() {
        return mX;
    }

    public int getY() {
        return mY;
    }

    /**
     * The constructor for the class 'Bowl'
     * @param bowlImage The bitmap containing an image of the bowl
     * @param viewWidth The width of the screen
     * @param viewHeight The height of the screen
     */

    public Bowl(Bitmap bowlImage, int viewWidth, int viewHeight) {
        this.bowlImage = bowlImage;
        mX = viewWidth / 2;
        mY = viewHeight - 166;
    }

    /**
     * Update the position of the bowl with the given arguments
     *
     * @param newX the new X position to move to
     * @param newY the new Y position to move to
     */
    public void update(int newX, int newY) {
        mX = newX;
    }

    /**
     * Draw the bowl on the given canvas
     *
     * @param canvas the canvas to draw to
     */
    public void draw(Canvas canvas){
        canvas.drawBitmap(bowlImage, mX, mY, null);
    }
}
