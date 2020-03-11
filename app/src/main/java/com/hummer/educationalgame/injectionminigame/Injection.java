package com.hummer.educationalgame.injectionminigame;

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
    private Rect injection;
    private int color;

    public Rect getInjection()
    {
        return injection;
    }

    public Injection(Rect injection, int color)
    {
        this.injection = injection;
        this.color = color;

        BitmapFactory bf = new BitmapFactory();
        Bitmap injectionImg = bf.decodeResource(InjectionConstants.CURRENT_CONTEXT.getResources(), R.drawable.injection);
    }

    @Override
    public void draw(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawRect(injection, paint);
    }

    @Override
    public void update()
    {

    }

    public void update(Point point)
    {
        injection.set(point.x - injection.width()/2, point.y - injection.height()/2, point.x + injection.width()/2, point.y + injection.height()/2);
    }

}
