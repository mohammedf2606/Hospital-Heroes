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
 * CreamSplatter is the class that represents the bitmap that is shown when the player
 * hovers over the cream_outline. The opacity of the bitmap increases while the player
 * continues hovering, to represent the progress.
 *
 * @author Jawad Zeidan
 * @version 1.0
 */

public class CreamSplatter {
    private Bitmap image;

    /**
     * The constructor for the class 'CreamSplatter'
     * @param res The resources associated with the package
     */
    public CreamSplatter(Resources res) {
        image = BitmapFactory.decodeResource(res, R.drawable.cream);
        image = Bitmap.createScaledBitmap(image, 100, 100, false);
    }

    /**
     * Draws the bitmap image onto the canvas.
     *
     * @param  canvas   the canvas the image is to be drawn on
     * @param  x   the x coordinate of the area where the bitmap should be drawn
     * @param  y   the y coordinate of the area where the bitmap should be drawn
     * @param  paint  the paint to be applied to the bitmap
     */
    public void draw(Canvas canvas, int x, int y, Paint paint) {
        canvas.drawBitmap(image, x, y, paint);
    }

    /**
     * Draw a darkened version of the bitmap onto the canvas
     *
     * @param  canvas  the canvas the image is to be drawn on
     * @param  x  the x coordinate of the area the image is to be drawn on
     * @param  y  the y coordinate of the area the image is to be drawn on
     */
    public void drawDarkenedImage(Canvas canvas, int x, int y) {
        Paint p = new Paint(Color.RED);
        ColorFilter filter = new LightingColorFilter(0xFF7F7F7F, 0x00000000);    // darken
        p.setColorFilter(filter);
        canvas.drawBitmap(image, x, y, p);
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
