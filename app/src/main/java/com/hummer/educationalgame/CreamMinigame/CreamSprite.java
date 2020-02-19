package com.hummer.educationalgame.CreamMinigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.hummer.educationalgame.R;

public class CreamSprite {
    private Bitmap image;
    private int height, width;
    private int x, y;

    public CreamSprite(Resources resources) {
        image = BitmapFactory.decodeResource(resources, R.drawable.creamtube);
        image = Bitmap.createScaledBitmap(image, 100, 100, false);
        height = image.getHeight();
        width = image.getWidth();
    }

    public void draw(Canvas canvas, int xCoord, int yCoord) {
        x = xCoord;
        y = yCoord;
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

    public Rect getHitbox() {
        return new Rect(x, y, x + width, y + height);
    }

}
