package com.hummer.educationalgame.injectionminigame;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class InjectionBody implements InjectionGameObject
{
    private Rect body;
    private int color;

    public InjectionBody(Rect body, int color)
    {
        this.body = body;
        this.color = color;
    }

    public boolean injectionCollide(Injection injection)
    {
        if(body.contains(injection.getInjection().left, injection.getInjection().top)
        || body.contains(injection.getInjection().right, injection.getInjection().top)
        || body.contains(injection.getInjection().left, injection.getInjection().bottom)
        || body.contains(injection.getInjection().right, injection.getInjection().bottom))
        {
            return true;
        }
        return false;
    }

    @Override
    public void draw(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawRect(body, paint);
    }

    @Override
    public void update()
    {

    }
}
