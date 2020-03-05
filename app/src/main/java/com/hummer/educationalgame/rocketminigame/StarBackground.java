package com.hummer.educationalgame.rocketminigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.hummer.educationalgame.R;

public class StarBackground {
    private Bitmap image;

    public StarBackground(int width, int height, Resources res) {
        image = BitmapFactory.decodeResource(res, R.drawable.star_background);
        image = Bitmap.createScaledBitmap(image, width, height, false);
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, 0, 0,  null);
    }
}
