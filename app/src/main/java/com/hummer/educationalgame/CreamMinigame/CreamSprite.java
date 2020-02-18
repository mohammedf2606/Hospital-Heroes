package com.hummer.educationalgame.CreamMinigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.hummer.educationalgame.R;

public class CreamSprite {
    private Bitmap image;
    private int x, y;

    public CreamSprite(int x, int y, Resources resources) {
        this.x = x;
        this.y = y;
        image = BitmapFactory.decodeResource(resources, R.drawable.creamsplat);
        image = Bitmap.createScaledBitmap(image, 100, 100, false);
    }

    public void draw(Canvas canvas, int xCoord, int yCoord) {
        canvas.drawBitmap(image, xCoord, yCoord, null);
    }

    public void update() {

    }

    public Bitmap getBitmap() {
        return image;
    }

}
