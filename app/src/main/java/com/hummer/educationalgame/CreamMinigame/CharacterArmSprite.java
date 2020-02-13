package com.hummer.educationalgame.CreamMinigame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class CharacterArmSprite {
    private Bitmap image;
    private int xCoord;
    private int yCoord;

    public CharacterArmSprite(Bitmap bmp) {
        image = bmp;
        xCoord = 0;
        yCoord = 0;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, xCoord, yCoord, null);
    }

    public void update() {

    }
}
