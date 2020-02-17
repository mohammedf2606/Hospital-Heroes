package com.hummer.educationalgame.CreamMinigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;

import com.hummer.educationalgame.R;

public class CharacterArmSprite {
    private Bitmap image;
    private int xCoord;
    private int yCoord;

    public CharacterArmSprite(int x, int y, Resources resources) {
        xCoord = x;
        yCoord = y;
        try {
            image = BitmapFactory.decodeResource(resources, R.drawable.arm);
//            image = Bitmap.createScaledBitmap(image, x, y, false);
            Matrix matrix = new Matrix();
            matrix.preScale(-1.0f, 1.0f);
            image = Bitmap.createBitmap(image, 0, 0, image.getWidth(), image.getHeight(), matrix, false);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, 0, 0, null);
    }

    public void update() {

    }
}
