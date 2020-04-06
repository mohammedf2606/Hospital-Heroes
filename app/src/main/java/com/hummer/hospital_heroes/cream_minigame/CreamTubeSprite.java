package com.hummer.hospital_heroes.cream_minigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.hummer.hospital_heroes.R;

/**
 * CreamTubeSprite represents the image that is shown when the player
 * touches the screen, more specifically the 'arm' sprite. The image is
 * a tube of 'magic cream'. Once the tube makes contact with the cream application
 * locations, animations are processed.
 *
 * @author Jawad Zeidan
 * @version 1.0
 */

public class CreamTubeSprite {
    private Bitmap image;
    private int height, width;
    private int x, y;

    /**
     * The constructor for the class 'CreamTubeSprite'
     * @param resources The resources associated with the package
     */
    public CreamTubeSprite(Resources resources) {
        image = BitmapFactory.decodeResource(resources, R.drawable.cream_tube);
//        image = Bitmap.createScaledBitmap(image, 100, 100, false);
        height = image.getHeight();
        width = image.getWidth();
    }

    /**
     * Draw the bitmap image onto the canvas
     *
     * @param  canvas   the canvas the image is to be drawn onto
     * @param  xCoord   the x coordinate of the area the image is to be drawn into
     * @param  yCoord   the y coordinate of the area the image is to be drawn into
     */
    public void draw(Canvas canvas, int xCoord, int yCoord) {
        x = xCoord;
        y = yCoord;
        canvas.drawBitmap(image, xCoord, yCoord, null);
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
     * Returns the height of the bitmap image.
     *
     * @return  height  the height of the bitmap image
     */
    public int getHeight() {
        return height;
    }

    /**
     * Returns the width of the bitmap image.
     *
     * @return  width  the width of the bitmap image
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns the rectangular hitbox of the image. Used for collisions.
     *
     * @return  Rect  the rectangle 'hitbox' of the image
     */
    public Rect getHitbox() {
        return new Rect(x, y + height - 10, x + 10, y + height);
    }
}
