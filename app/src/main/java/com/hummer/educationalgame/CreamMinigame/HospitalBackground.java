package com.hummer.educationalgame.CreamMinigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;

import com.hummer.educationalgame.R;

/**
 * HospitalBackground represents the background image of the 'cream minigame'
 * It is supposed to be the hospital room the child is to be sat in once the cream
 * is to be applied. It is in the form of a full screen bitmap which is drawn.
 *
 * @author Jawad Zeidan
 * @version 1.0
 */

public class HospitalBackground {
    private Bitmap image;

    public HospitalBackground(int x, int y, Resources resources) {
        image = BitmapFactory.decodeResource(resources, R.drawable.hospitalroom);
        image = Bitmap.createScaledBitmap(image, x, y, false);
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, 0, 0, null);
    }

    public void drawDarkenedImage(Canvas canvas) {
        Paint p = new Paint(Color.RED);
        ColorFilter filter = new LightingColorFilter(0xFF7F7F7F, 0x00000000);    // darken
        p.setColorFilter(filter);
        canvas.drawBitmap(image, 0, 0, p);
    }

    public void update() {

    }
}