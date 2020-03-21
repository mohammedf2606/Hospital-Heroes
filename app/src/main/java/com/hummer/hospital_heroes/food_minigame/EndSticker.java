package com.hummer.hospital_heroes.food_minigame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class EndSticker {
    private Bitmap image;
    private int x, y;

    public EndSticker(Bitmap sticker, int viewWidth, int viewHeight) {
        image = Bitmap.createScaledBitmap(sticker, 400, 400, false);
        x = viewWidth / 2 - (image.getWidth()/2);
        y = viewHeight / 2 - (image.getHeight()/2);
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, x, y, null);
    }
}