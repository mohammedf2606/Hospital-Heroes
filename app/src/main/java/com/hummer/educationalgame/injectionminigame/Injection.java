package com.hummer.educationalgame.injectionminigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import com.hummer.educationalgame.R;

/**
 * Injection is the class of the game that represents the injection. It builds
 * and displays the injection and its components.
 *
 * @author Fareed Faisal
 * @version 1.0
 */
public class Injection implements InjectionGameObject
{
    private Bitmap image;
    private int height, width;
    private int x, y;

    public Injection(Resources resources)
    {
        image = BitmapFactory.decodeResource(resources, R.drawable.butterfly);
        height = image.getHeight();
        width = image.getWidth();
    }

    @Override
    public void draw(Canvas canvas, int xCoord, int yCoord)
    {
        x = xCoord;
        y = yCoord;
        canvas.drawBitmap(image, xCoord, yCoord, null);
    }

    @Override
    public void update()
    {

    }

    public void update(Point point)
    {
    //    injection.set(point.x - injection.width()/2, point.y - injection.height()/2, point.x + injection.width()/2, point.y + injection.height()/2);
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

    //public Rect getInjection() { return injection; }

}
