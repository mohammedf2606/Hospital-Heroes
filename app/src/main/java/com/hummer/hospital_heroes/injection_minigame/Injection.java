package com.hummer.hospital_heroes.injection_minigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import com.hummer.hospital_heroes.R;

/**
 * Injection is the class of the game that represents the injection. It builds
 * and displays the injection and its components.
 *
 * @author Fareed Faisal
 * @version 1.0
 */
public class Injection implements InjectionGameObject
{
    private Bitmap image;
    private int height, width;
    private int x, y;

    /**
     * Constructor for the class sets up sprite
     * @param resources Resources object used to produce Bitmap image
     */
    public Injection(Resources resources)
    {
        image = BitmapFactory.decodeResource(resources, R.drawable.butterfly);
        image = Bitmap.createScaledBitmap(image, 150,150,false);
        height = image.getHeight();
        width = image.getWidth();
    }

    /**
     * Draw method to display butterfly
     * @param xCoord The initial x-coordinate of the sprite
     * @param yCoord The initial y-coordinate of the sprite
     * @param canvas The canvas to be drawn on
     */
    @Override
    public void draw(Canvas canvas, int xCoord, int yCoord)
    {
        x = xCoord;
        y = yCoord;
        canvas.drawBitmap(image, xCoord, yCoord, null);
    }

    @Override
    public void update()
    {

    }

    /**
     * Returns the bitmap image.
     *
     * @return  image  the bitmap image
     */
    public Bitmap getBitmap() {
        return image;
    }

    /**
     * Returns the height of the bitmap image
     *
     * @return  image.getHeight()  the height of the bitmap image
     */
    public int getHeight() {
        return height;
    }

    /**
     * Returns the width of the bitmap image
     *
     * @return  image.getWidth()  the width of the bitmap image
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns the hitbox of the bitmap. Used for collisions.
     *
     * @return  Rect  the rectangular hitbox of the image
     */
    public Rect getHitbox() {
        return new Rect(x, y, x + width, y + height);
    }

}
