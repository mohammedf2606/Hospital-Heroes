package com.hummer.educationalgame.CreamMinigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.hummer.educationalgame.R;

public class CreamSplatter2 {
    private Bitmap image;

    public CreamSplatter2(Resources res) {
        image = BitmapFactory.decodeResource(res, R.drawable.cream2);
        image = Bitmap.createScaledBitmap(image, 100, 100, false);
    }

    public void draw(Canvas canvas, int x, int y) {
        canvas.drawBitmap(image, x, y, null);
    }
}
