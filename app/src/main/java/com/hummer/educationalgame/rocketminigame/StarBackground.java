package com.hummer.educationalgame.rocketminigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;

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

    public void drawDarkenedImage(Canvas canvas) {
        Paint p = new Paint(Color.RED);
        ColorFilter filter = new LightingColorFilter(0xFF7F7F7F, 0x00000000);    // darken
        p.setColorFilter(filter);
        canvas.drawBitmap(image, 0, 0, p);
    }
}
