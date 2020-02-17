package com.hummer.educationalgame.CreamMinigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.hummer.educationalgame.R;

public class HospitalBackground {
    private Bitmap image;
    private int xCoord;
    private int yCoord;

    public HospitalBackground(int x, int y, Resources resources) {
        xCoord = x;
        yCoord = y;
        image = BitmapFactory.decodeResource(resources, R.drawable.hospitalroom);
        image = Bitmap.createScaledBitmap(image, x, y, false);

    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, 0, 0, null);
    }

    public void update() {

    }
}