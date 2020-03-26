package com.hummer.hospital_heroes.rocket_minigame;

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
 * StarBackground represents the background image of the 'Rocket minigame'
 * It is in the form of a full screen bitmap which is drawn.
 *
 * @author Fahim Mohammed, Jawad Zeidan
 * @version 1.0
 */
public class StarBackground {
    private Bitmap image;
    /**
     * The constructor for the class 'StarBackground'
     * @param width The width of the screen
     * @param height The height of the screen
     * @param res The resources associated with the package
     */
    public StarBackground(int width, int height, Resources res) {
        image = BitmapFactory.decodeResource(res, R.drawable.starbackground);
        image = Bitmap.createScaledBitmap(image, width, height, false);
    }

    /**
     * Draws the bitmap image onto the canvas
     *
     * @param  canvas  the canvas the image is to be drawn onto
     */
    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, 0, 0,  null);
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
}
