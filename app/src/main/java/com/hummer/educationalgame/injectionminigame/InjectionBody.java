package com.hummer.educationalgame.injectionminigame;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.hummer.educationalgame.R;

/**
 * InjectionBody is the class of the game that represents the body part. It builds
 * and displays the body part and its components.
 *
 * @author Fareed Faisal
 * @version 1.0
 */
public class InjectionBody
{
    private Rect body;
    private int color;

    public Rect getInjectionBody()
    {
        return body;
    }

    public InjectionBody(Rect body, int color)
    {
        this.body = body;
        this.color = color;

        BitmapFactory bf = new BitmapFactory();
        Bitmap injectionBodyImg = bf.decodeResource(InjectionConstants.CURRENT_CONTEXT.getResources(), R.drawable.whitearm);
    }

    public boolean injectionCollide(Injection injection)
    {
        return Rect.intersects(body, injection.getHitbox());
    }


    public void draw(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawRect(body, paint);
    }

    public void update()
    {

    }
}
