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

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, xCoord, yCoord, null);
    }

    public void drawDarkenedImage(Canvas canvas) {
        Paint p = new Paint(Color.RED);
        ColorFilter filter = new LightingColorFilter(0xFF7F7F7F, 0x00000000);    // darken
        p.setColorFilter(filter);
        canvas.drawBitmap(image, xCoord, yCoord, p);
    }

    public int getX() {
        return xCoord;
    }

    public int getY() {
        return yCoord;
    }

    public int getHeight() {
        return image.getHeight();
    }

    public int getWidth() {
        return image.getWidth();
    }
}
