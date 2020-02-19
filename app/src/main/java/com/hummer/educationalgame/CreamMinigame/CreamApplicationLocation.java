package com.hummer.educationalgame.CreamMinigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.hummer.educationalgame.R;

public class CreamApplicationLocation {
    private Bitmap image;
    private int xCoord, yCoord;

    public CreamApplicationLocation(int x, int y, Resources res) {
        xCoord = x;
        yCoord = y;
        image = BitmapFactory.decodeResource(res, R.drawable.creamapplicationlocation);
        image = Bitmap.createScaledBitmap(image, 100, 100, false);
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, xCoord, yCoord, null);
    }

    public Rect getHitbox() {
        return new Rect(xCoord, yCoord, xCoord + image.getWidth(), yCoord + image.getHeight());
    }
}
