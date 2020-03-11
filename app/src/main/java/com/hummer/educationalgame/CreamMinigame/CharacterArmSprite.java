package com.hummer.educationalgame.CreamMinigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;

import com.hummer.educationalgame.R;

/**
 * CharacterArmSprite is the class that contains the 'arm' bitmap sprite
 * which is to have the cream applied onto. The class contains methods such as
 * 'draw' which draws the bitmap onto the canvas (screen) and accessor methods such as
 * get height of image and get width.
 *
 * @author Jawad Zeidan
 * @version 1.0
 */

public class CharacterArmSprite {
    private Bitmap image;
    private int xCoord;
    private int yCoord;


    /**
     * The constructor for the class 'CharacterArmSprite'
     * @param x The width of the screen
     * @param y The height of the screen
     * @param resources The resources associated with the package
     * @param whiteArm Boolean stating whether the arm of the character is white or not
     */
    public CharacterArmSprite(int x, int y, Resources resources, boolean whiteArm) {
        if(whiteArm) {
            image = BitmapFactory.decodeResource(resources, R.drawable.whitearm);
        } else {
            image = BitmapFactory.decodeResource(resources, R.drawable.blackarm);
        }
//            image = Bitmap.createScaledBitmap(image, x, y, false);
        xCoord = 0;
        yCoord = y/3  - image.getHeight()/2;
    }

    /**
     * Draw the bitmap onto the canvas.
     *
     * @param  canvas   the canvas to be drawn on
     */
    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, xCoord, yCoord, null);
    }

    /**
     * Draw a darkened version of the bitmap onto the canvas.
     *
     * @param  canvas the canvas to be drawn on
     */
    public void drawDarkenedImage(Canvas canvas) {
        Paint p = new Paint(Color.RED);
        ColorFilter filter = new LightingColorFilter(0xFF7F7F7F, 0x00000000);    // darken
        p.setColorFilter(filter);
        canvas.drawBitmap(image, xCoord, yCoord, p);
    }

    /**
     * Return the x coordinate of the bitmap
     *
     * @return  xCoord  the value of x
     */
    public int getX() {
        return xCoord;
    }

    /**
     * Return the y coordinate of the bitmap
     *
     * @return  yCoord  the value of y
     */
    public int getY() {
        return yCoord;
    }

    /**
     * Return the height of the bitmap image
     *
     * @return  image.getHeight()  the value of the height of the image
     */
    public int getHeight() {
        return image.getHeight();
    }

    /**
     * Return the width of the bitmap image
     *
     * @return  image.getWidth()  the value of the width of the image
     */
    public int getWidth() {
        return image.getWidth();
    }
}
