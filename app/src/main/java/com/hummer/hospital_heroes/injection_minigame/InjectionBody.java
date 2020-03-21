package com.hummer.hospital_heroes.injection_minigame;


import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.hummer.hospital_heroes.R;

/**
 * InjectionBody is the class of the game that represents the body part. It builds
 * and displays the body part and its components.
 *
 * @author Fareed Faisal
 * @version 1.0
 */
public class InjectionBody
{
    private Bitmap image;
    private int xCoord, yCoord;


    public InjectionBody(int x, int y, Resources res)
    {
        xCoord = x;
        yCoord = y;
        image = BitmapFactory.decodeResource(res, R.drawable.creamoutline);
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
