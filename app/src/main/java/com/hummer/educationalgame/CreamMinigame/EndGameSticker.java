package com.hummer.educationalgame.CreamMinigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.widget.ImageView;

import com.hummer.educationalgame.R;

public class EndGameSticker {
    private Bitmap image;
    private int xCoord, yCoord;
    private int width, height;

    public EndGameSticker(int x, int y, Resources resources) {
        xCoord = x;
        yCoord = y;
        image = BitmapFactory.decodeResource(resources, R.drawable.sticker);
        image = Bitmap.createScaledBitmap(image, 400, 400, false);
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, xCoord/2 - (image.getWidth()/2), yCoord/2 - (image.getHeight()/2), null);
    }

    public int drawAnimation(Canvas canvas) {
        width+=2;
        height+=2;
        if(width > 400) {
            width = 400;
            height = 400;
        }
        canvas.drawBitmap(Bitmap.createScaledBitmap(image, width, height, false), xCoord/2 - (width/2), yCoord/2 - (height/2), null);
        return width;
    }
}
