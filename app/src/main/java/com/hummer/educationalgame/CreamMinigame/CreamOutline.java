package com.hummer.educationalgame.CreamMinigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.hummer.educationalgame.R;

/**
 * CreamOutline is the class that contains the bitmap for the dotted
 * line that represents the area to apply the cream onto. The methods contained
 * consist of 'draw' which draws the bitmap onto the canvas (screen) and getHitBox which
 * returns a rectangle representing the image itself (used for collisions).
 *
 * @author Jawad Zeidan
 * @version 1.0
 */

public class CreamOutline {
    private Bitmap image;
    private int xCoord, yCoord;

    public CreamOutline(int x, int y, Resources res) {
        xCoord = x;
        yCoord = y;
        image = BitmapFactory.decodeResource(res, R.drawable.creamoutlinescaled);
        image = Bitmap.createScaledBitmap(image, 100, 100, false);
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, xCoord, yCoord, null);
    }

    public Rect getHitbox() {
        return new Rect(xCoord, yCoord, xCoord + image.getWidth(), yCoord + image.getHeight());
    }

    public int getXCoord() {
        return xCoord;
    }

    public int getYCoord() {
        return yCoord;
    }
}
