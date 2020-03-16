package com.hummer.educationalgame.CreamMinigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.hummer.educationalgame.R;

/**
 * CreamOutline is the class that contains the bitmap for the dotted
 * line that represents the area to apply the cream onto. The methods contained
 * consist of 'draw' which draws the bitmap onto the canvas (screen) and getHitBox which
 * returns a rectangle representing the image itself (used for collisions).
 *
 * @author Jawad Zeidan
 * @version 1.0
 */

public class CreamOutline {
    private Bitmap image;
    private int xCoord, yCoord;

    /**
     * The constructor for the class 'CreamOutline'
     * @param x The x coordinate of the area to be drawn onto
     * @param y The y coordinate of the area to be drawn onto
     * @param res The resources associated with the package
     */
    public CreamOutline(int x, int y, Resources res) {
        xCoord = x;
        yCoord = y;
        image = BitmapFactory.decodeResource(res, R.drawable.creamoutline);
        image = Bitmap.createScaledBitmap(image, 100, 100, false);
    }

    /**
     * Draw the bitmap onto the canvas
     *
     * @param  canvas the canvas to be drawn on
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
     * Return the x coordinate of the image drawn
     *
     * @return  xCoord  the value of x
     */
    public int getXCoord() {
        return xCoord;
    }

    /**
     * Return the y coordinate of the image drawn
     *
     * @return  yCoord the value of y
     */
    public int getYCoord() {
        return yCoord;
    }
}
