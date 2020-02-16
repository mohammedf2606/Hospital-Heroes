package com.hummer.educationalgame.injectionminigame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class InjectionGamePanel extends SurfaceView implements SurfaceHolder.Callback
{
    private InjectionMainThread thread;

    private Injection injection;
    private Point injectionPoint;

    public InjectionGamePanel(Context context)
    {
        super(context);

        getHolder().addCallback(this);

        thread = new InjectionMainThread(getHolder(), this);

        injection = new Injection(new Rect(100,100,200,200), Color.rgb(255,0,0));
        injectionPoint = new Point(150,150);

        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
    {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder)
    {
        thread = new InjectionMainThread(getHolder(), this);

        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder)
    {
        boolean retry = true;
        while(true)
        {
            try
            {
               thread.setRunning(false);
               thread.join();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            retry = false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                injectionPoint.set((int)event.getX(), (int)event.getY());
        }

        return true;
        //return super.onTouchEvent(event);
    }

    public void update()
    {
        injection.update(injectionPoint);
    }

    @Override
    public void draw(Canvas canvas)
    {
        super.draw(canvas);

        canvas.drawColor(Color.WHITE);

        injection.draw(canvas);
    }
}
