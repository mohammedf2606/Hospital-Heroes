package com.hummer.educationalgame.rocketminigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.widget.ImageView;

import com.hummer.educationalgame.R;

/**
 * Class for Astroid objects in the Rocket Minigame
 * @author Fahim Mohammed, Jawad Zeidan
 * @version 1.0
 */
public class Asteroid {

    private Bitmap image;
    private int x, y;

    /**
     * Constructor for Asteroid objects
     * @param res Resources object to generate bitmap image
     * @param x the x-coordinate where the asteroid will placed
     * @param y the y-coordinate where the asteroid will placed
     */
    public Asteroid(Resources res, int x, int y) {
        this.x = x;
        this.y = y;
        image = BitmapFactory.decodeResource(res, R.drawable.asteroid);
        image = Bitmap.createScaledBitmap(image, 200,200, false);
    }

    /**
     * Draw method that draws the asteroid picture on the given canvas
     * @param canvas the canvas to be drawn on
     */
    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, x, y, null);
    }

    public void update() {

    }

    public int getHeight() {
        return image.getHeight();
    }

    public int getWidth() {
        return image.getWidth();
    }

    public Rect getHitbox() {
        return new Rect(x + 20, y + 20, x + image.getWidth() - 20, y + image.getHeight() - 20);
    }
}
