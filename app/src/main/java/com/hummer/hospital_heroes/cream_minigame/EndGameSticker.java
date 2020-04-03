package com.hummer.hospital_heroes.cream_minigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.hummer.hospital_heroes.R;

/**
 * EndGameSticker is the class that represents the victory
 * 'badge' that appears once the game is completed successfully.
 * The badge is a bitmap that is drawn onto the canvas and the rate at
 * which it expands and appears can be controlled through the numbers
 * the width and height increment by.
 *
 * @author Jawad Zeidan
 * @version 1.0
 */

public class EndGameSticker {
    private Bitmap image;
    private int xCoord, yCoord;
    private int width, height;

    /**
     * The constructor for the class 'EndGameSticker'
     * @param x The width of the screen
     * @param y The height of the screen
     * @param resources The resources associated with the package
     */
    public EndGameSticker(int x, int y, Resources resources) {
        xCoord = x;
        yCoord = y;
        image = BitmapFactory.decodeResource(resources, R.drawable.badge);
//        image = Bitmap.createScaledBitmap(image, 400, 400, false);
    }

    /**
     * Draws the bitmap image onto the canvas.
     *
     * @param  canvas  the canvas the bitmap is to be drawn on
     */
    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, xCoord/2 - (image.getWidth()/2), yCoord/2 - (image.getHeight()/2), null);
    }

    /**
     * Draws the animation of the sticker increasing in size.
     *
     * @param  canvas  the canvas the bitmap is to be drawn on
     * @return  width  the maximum width of the sticker
     */
    public int drawAnimation(Canvas canvas) {
        width+=10;
        height+=10;
        if(width > getWidth()) {
            width = getWidth();
            height = getHeight();
        }
        canvas.drawBitmap(Bitmap.createScaledBitmap(image, width, height, false), xCoord/2 - (width/2), yCoord/2 - (height/2), null);
        return width;
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
     * Returns the height of the bitmap image
     *
     * @return  image.getHeight()  the height of the bitmap image
     */
    public int getHeight() {
        return image.getHeight();
    }
}
