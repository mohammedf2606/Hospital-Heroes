package com.hummer.educationalgame.CreamMinigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;

import com.hummer.educationalgame.R;

public class CharacterArmSprite {
    private Bitmap image;
    private int xCoord;
    private int yCoord;


    public CharacterArmSprite(int x, int y, Resources resources) {
        xCoord = 0;
        yCoord = y/3;
        try {
            image = BitmapFactory.decodeResource(resources, R.drawable.arm);
            image = Bitmap.createScaledBitmap(image, x, yCoord, false);
            Matrix matrix = new Matrix();
            matrix.preScale(-1.0f, 1.0f);
            image = Bitmap.createBitmap(image, 0, 0, image.getWidth(), image.getHeight(), matrix, false);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, xCoord, yCoord, null);
    }

    public void update() {

    }

    public int getX() {
        return xCoord;
    }

    public int getY() {
        return yCoord;
    }

    public int getHeight() {
        return image.getHeight();
    }

    public int getWidth() {
        return image.getWidth();
    }

    public Rect getHitbox() {
        return new Rect(xCoord + 100, yCoord, xCoord + getWidth(), yCoord + getHeight());
    }
//
//    public Rect getHitbox2() {
//        return new Rect();
//    }
}
