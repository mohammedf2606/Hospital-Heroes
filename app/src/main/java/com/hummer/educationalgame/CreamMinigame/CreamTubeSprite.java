package com.hummer.educationalgame.CreamMinigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.hummer.educationalgame.R;

/**
 * CreamTubeSprite represents the image that is shown when the player
 * touches the screen, more specifically the 'arm' sprite. The image is
 * a tube of 'magic cream'. Once the tube makes contact with the cream application
 * locations, animations are processed.
 *
 * @author Jawad Zeidan
 * @version 1.0
 */

public class CreamTubeSprite {
    private Bitmap image;
    private int height, width;
    private int x, y;

    public CreamTubeSprite(Resources resources) {
        image = BitmapFactory.decodeResource(resources, R.drawable.creamtube);
//        image = Bitmap.createScaledBitmap(image, 100, 100, false);
        height = image.getHeight();
        width = image.getWidth();
    }

    public void draw(Canvas canvas, int xCoord, int yCoord) {
        x = xCoord;
        y = yCoord;
        canvas.drawBitmap(image, xCoord, yCoord, null);
    }

    public void update() {

    }

    public Bitmap getBitmap() {
        return image;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Rect getHitbox() {
        return new Rect(x, y + height - 10, x + 10, y + height);
    }

}
