package com.hummer.educationalgame.CreamMinigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.hummer.educationalgame.R;

public class HospitalBackground {
    private int xCoord = 0, yCoord = 0;
    private Bitmap background;

    public HospitalBackground(int x, int y, Resources resources) {
        background = BitmapFactory.decodeResource(resources, R.drawable.hospitalroom);
        background = Bitmap.createScaledBitmap(background, x, y, false);
    }
}
