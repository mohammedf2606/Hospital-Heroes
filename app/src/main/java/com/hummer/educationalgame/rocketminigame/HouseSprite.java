package com.hummer.educationalgame.rocketminigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.hummer.educationalgame.R;

public class HouseSprite {
    private Bitmap image;
    private int xCoord, yCoord;

    public HouseSprite(Resources res) {
        image = BitmapFactory.decodeResource(res, R.drawable.house);
        image = Bitmap.createScaledBitmap(image, 200, 200, false);
    }

    public void draw(int width, int height, Canvas canvas) {
        xCoord = width;
        yCoord = height;
        canvas.drawBitmap(image, width, height, null);
    }

    public Rect getHitBox() {
        return new Rect(xCoord, yCoord, xCoord + image.getWidth(), yCoord + image.getHeight());
    }

    public int getXCoord() {
        return xCoord;
    }

    public int getYCoord() {
        return yCoord;
    }

    public int getHeight() {
        return image.getHeight();
    }

    public int getWidth() {
        return image.getWidth();
    }
}

