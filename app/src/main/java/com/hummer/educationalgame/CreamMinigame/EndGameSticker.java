package com.hummer.educationalgame.CreamMinigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.widget.ImageView;

import com.hummer.educationalgame.R;

/**
 * EndGameSticker is the class that represents the victory
 * 'badge' that appears once the game is completed successfully.
 * The badge is a bitmap that is drawn onto the canvas and the rate at
 * which it expands and appears can be controlled through the numbers
 * the width and height increment by.
 *
 * @author Jawad Zeidan
 * @version 1.0
 */

public class EndGameSticker {
    private Bitmap image;
    private int xCoord, yCoord;
    private int width, height;

    public EndGameSticker(int x, int y, Resources resources) {
        xCoord = x;
        yCoord = y;
        image = BitmapFactory.decodeResource(resources, R.drawable.successbadge);
        image = Bitmap.createScaledBitmap(image, 400, 400, false);
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(image, xCoord/2 - (image.getWidth()/2), yCoord/2 - (image.getHeight()/2), null);
    }

    public int drawAnimation(Canvas canvas) {
        width+=10;
        height+=10;
        if(width > getWidth()) {
            width = getWidth();
            height = getHeight();
        }
        canvas.drawBitmap(Bitmap.createScaledBitmap(image, width, height, false), xCoord/2 - (width/2), yCoord/2 - (height/2), null);
        return width;
    }

    public int getWidth() {
        return image.getWidth();
    }

    public int getHeight() {
        return image.getHeight();
    }
}
