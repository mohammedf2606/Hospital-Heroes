package com.hummer.educationalgame.rocketminigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.hummer.educationalgame.R;

public class RocketSprite {
    private Bitmap image;
    private int xCoord, yCoord;

    public RocketSprite(Resources res) {
        image = BitmapFactory.decodeResource(res, R.drawable.rocket);
        image = Bitmap.createScaledBitmap(image, 100, 100, false);
    }

    public void draw(int x, int y, Canvas canvas) {
        xCoord = x;
        yCoord = y;
        canvas.drawBitmap(image, x, y, null);
    }

    public int getHeight() {
        return image.getHeight();
    }

    public int getWidth() {
        return image.getWidth();
    }

    public Rect getHitbox() {
        return new Rect(xCoord, yCoord, xCoord + image.getWidth(), yCoord + image.getHeight());
    }
}
