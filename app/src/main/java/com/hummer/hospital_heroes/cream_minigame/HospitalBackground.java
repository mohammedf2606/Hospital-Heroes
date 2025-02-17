package com.hummer.hospital_heroes.cream_minigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;

import com.hummer.hospital_heroes.R;

/**
 * HospitalBackground represents the background image of the 'cream minigame'
 * It is supposed to be the hospital room the child is to be sat in once the cream
 * is to be applied. It is in the form of a full screen bitmap which is drawn.
 *
 * @author Jawad Zeidan
 * @version 1.0
 */

public class HospitalBackground {
    private Bitmap image;

    /**
     *  The constructor for the class 'HospitalBackground'
     * @param x The width of the screen
     * @param y The height of the screen
     * @param resources The resources associated with the package
     */
    public HospitalBackground(int x, int y, Resources resources) {
        image = BitmapFactory.decodeResource(resources, R.drawable.injectionroombackground);
        image = Bitmap.createScaledBitmap(image, x, y, false);
    }

    /**
     * Draws the bitmap image onto the canvas
     *
     * @param  canvas  the canvas the image is to be drawn onto
     */
    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, 0, 0, null);
    }

    /**
     * Draws a darkened version of the image onto the canvas
     *
     * @param  canvas  the canvas the image is to be drawn onto
     */
    public void drawDarkenedImage(Canvas canvas) {
        Paint p = new Paint(Color.RED);
        ColorFilter filter = new LightingColorFilter(0xFF7F7F7F, 0x00000000);    // darken
        p.setColorFilter(filter);
        canvas.drawBitmap(image, 0, 0, p);
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