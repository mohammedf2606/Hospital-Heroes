package com.hummer.educationalgame.rocketminigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;

import com.hummer.educationalgame.R;

public class RocketSprite {
    private Bitmap image;
    private int xCoord, yCoord;

    public RocketSprite(Resources res) {
        image = BitmapFactory.decodeResource(res, R.drawable.rocket);
        image = Bitmap.createScaledBitmap(image, 50, 100, false);
        Matrix matrix = new Matrix();
        matrix.postRotate(90);
        image = Bitmap.createBitmap(image, 0, 0, getWidth(), getHeight(), matrix, false);
    }

    public void draw(int x, int y, Canvas canvas) {
        xCoord = x;
        yCoord = y;
        canvas.drawBitmap(image, x, y, null);
    }
    public void draw(int x, int y, Matrix matrix, Canvas canvas) {
        xCoord = x;
        yCoord = y;
        canvas.drawBitmap(image, matrix, null);
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

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }
}
