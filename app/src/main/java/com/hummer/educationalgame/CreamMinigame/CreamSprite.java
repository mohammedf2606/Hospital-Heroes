package com.hummer.educationalgame.CreamMinigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.hummer.educationalgame.R;

public class CreamSprite {
    private Bitmap image;
    private int height, width;

    public CreamSprite(Resources resources) {
        image = BitmapFactory.decodeResource(resources, R.drawable.creamtube);
        image = Bitmap.createScaledBitmap(image, 100, 100, false);
        height = image.getHeight();
        width = image.getWidth();
    }

    public void draw(Canvas canvas, int xCoord, int yCoord) {
        canvas.drawBitmap(image, xCoord, yCoord, null);
    }

    public void update() {

    }

    public Bitmap getBitmap() {
        return image;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

}
