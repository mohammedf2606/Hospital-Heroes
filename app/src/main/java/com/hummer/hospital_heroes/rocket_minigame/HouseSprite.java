package com.hummer.hospital_heroes.rocket_minigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.hummer.hospital_heroes.R;

/**
 * Class for the House sprite at the end of the Rocket minigame
 * @author Fahim Mohammed, Jawad Zeidan
 * @version 1.0
 */
public class HouseSprite {
    private Bitmap image;
    private int xCoord, yCoord;

    /**
     * Constructor for the class 'HouseSprite'
     * @param res Resources object used to produce Bitmap image
     */
    public HouseSprite(Resources res) {
        image = BitmapFactory.decodeResource(res, R.drawable.house);
        image = Bitmap.createScaledBitmap(image, 200, 200, false);
    }

    /**
     * Draw method used to draw the HouseSprite
     * @param width The width of the sprite
     * @param height The height of the sprite
     * @param canvas The canvas to be drawn on
     */
    public void draw(int width, int height, Canvas canvas) {
        xCoord = width;
        yCoord = height;
        canvas.drawBitmap(image, width, height, null);
    }

    /**
     * Returns the hitbox of the bitmap. Used for collisions.
     *
     * @return  Rect  the rectangular hitbox of the image
     */
    public Rect getHitBox() {
        return new Rect(xCoord + 80, yCoord + 80, xCoord + getWidth() - 80, yCoord + getHeight() - 80);
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
}

