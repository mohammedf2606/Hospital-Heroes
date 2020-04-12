package com.hummer.hospital_heroes.rocket_minigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;

import com.hummer.hospital_heroes.R;

/**
 * Class for the Rocket sprite that is navigated throughout the Rocket minigame
 * @author Fahim Mohammed, Jawad Zeidan
 * @version 1.0
 */
public class RocketSprite {
    private Bitmap image;
    private int xCoord, yCoord;

    /**
     * Constructor for the class 'RocketSprite'
     * @param res Resources object used to produce Bitmap image
     */
    public RocketSprite(Resources res) {
        image = BitmapFactory.decodeResource(res, R.drawable.rocket);
        image = Bitmap.createScaledBitmap(image, 75, 150, false);
        Matrix matrix = new Matrix();
        matrix.postRotate(90);
        image = Bitmap.createBitmap(image, 0, 0, getWidth(), getHeight(), matrix, false);
    }

    /**
     * Draw method used to draw the RocketSprite
     * @param x The initial x-coordinate of the sprite
     * @param y The initial y-coordinate of the sprite
     * @param canvas The canvas to be drawn on
     */
    public void draw(int x, int y, Canvas canvas) {
        xCoord = x;
        yCoord = y;
        canvas.drawBitmap(image, x, y, null);
    }

    /**
     * Returns the height of the bitmap image
     *
     * @return  image.getHeight()  the height of the bitmap image
     */
    public int getHeight() {
        return image.getHeight();
    }

    /**
     * Returns the width of the bitmap image
     *
     * @return  image.getWidth()  the width of the bitmap image
     */
    public int getWidth() {
        return image.getWidth();
    }

    /**
     * Returns the hitbox of the bitmap. Used for collisions.
     *
     * @return  Rect  the rectangular hitbox of the image
     */
    public Rect getHitbox() {
        return new Rect(xCoord, yCoord, xCoord + image.getWidth(), yCoord + image.getHeight());
    }

    /**
     * Returns the bitmap image.
     *
     * @return  image  the bitmap image
     */
    public Bitmap getBitmap() {
        return image;
    }
}
