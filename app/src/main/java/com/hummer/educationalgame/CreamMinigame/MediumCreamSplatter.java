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
 * CreamSplatter2 is the class that represents the bitmap that is shown when
 * the player applies a partial amount of cream. The methods consist of draw which draws
 * the bitmap onto the canvas (screen) and drawDarkenedImage which draws a darker version
 * of the image onto the canvas.
 *
 * @author Jawad Zeidan
 * @version 1.0
 */

public class MediumCreamSplatter {
    private Bitmap image;

    public MediumCreamSplatter(Resources res) {
        image = BitmapFactory.decodeResource(res, R.drawable.cream2);
        image = Bitmap.createScaledBitmap(image, 100, 100, false);
    }

    public void draw(Canvas canvas, int x, int y) {
        canvas.drawBitmap(image, x, y, null);
    }

    public void drawDarkenedImage(Canvas canvas, int x, int y) {
        Paint p = new Paint(Color.RED);
        ColorFilter filter = new LightingColorFilter(0xFF7F7F7F, 0x00000000);    // darken
        p.setColorFilter(filter);
        canvas.drawBitmap(image, x, y, p);
    }
}
