package com.hummer.hospital_heroes.injection_minigame;


import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.hummer.hospital_heroes.R;

/**
 * InjectionBody is the class of the game that represents the body part. It builds
 * and displays the body part and its components.
 *
 * @author Fareed Faisal
 * @version 1.0
 */
public class InjectionBody
{
    private Bitmap image;
    private int xCoord, yCoord;

    /**
     * Constructor for the class sets up sprite
     * @param res Resources object used to produce Bitmap image
     */
    public InjectionBody(int x, int y, Resources res)
    {
        xCoord = x;
        yCoord = y;
        image = BitmapFactory.decodeResource(res, R.drawable.cream_outline);
        image = Bitmap.createScaledBitmap(image, 100, 100, false);
    }

    /**
     * Draw method used to draw the body
     * @param canvas The canvas to be drawn on
     */
    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, xCoord, yCoord, null);
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
     * Returns the x coordinate of bitmap
     *
     * @return  xCoord the x coordinate
     */
    public int getXCoord() {
        return xCoord;
    }

    /**
     * Returns the y coordinate of bitmap
     *
     * @return  yCoord the y coordinate
     */
    public int getYCoord() {
        return yCoord;
    }
}
