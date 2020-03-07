package com.hummer.educationalgame.rocketminigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.widget.ImageView;

import com.hummer.educationalgame.R;

public class Asteroid {

    private Bitmap image;
    private int x, y;

    public Asteroid(Resources res, int x, int y) {
        this.x = x;
        this.y = y;
        image = BitmapFactory.decodeResource(res, R.drawable.asteroid);
        image = Bitmap.createScaledBitmap(image, 200,200, false);
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, x, y, null);
    }

    public void update() {

    }

    public int getHeight() {
        return image.getHeight();
    }

    public int getWidth() {
        return image.getWidth();
    }

    public Rect getHitbox() {
        return new Rect(x + 20, y + 20, x + image.getWidth() - 20, y + image.getHeight() - 20);
    }
}
