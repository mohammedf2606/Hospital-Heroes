package com.hummer.educationalgame.injectionminigame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.provider.SyncStateContract;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class InjectionGamePanel extends SurfaceView implements SurfaceHolder.Callback
{
    private InjectionMainThread thread;

    private Injection injection;
    private Point injectionPoint;
    private InjectionBody injectionBody;

    private boolean movingInjection = false;

    private boolean gameOver = false;

    public InjectionGamePanel(Context context)
    {
        super(context);

        getHolder().addCallback(this);

        thread = new InjectionMainThread(getHolder(), this);

        injection = new Injection(new Rect(100,100,200,200), Color.rgb(255,0,0));
        injectionPoint = new Point(3*InjectionConstants.SCREEN_WIDTH/4, InjectionConstants.SCREEN_HEIGHT/4);
        injection.update(injectionPoint);

        injectionBody = new InjectionBody(new Rect(200,200,400,400), Color.BLACK);

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
                if(!gameOver && injection.getInjection().contains((int)event.getX(), (int)event.getY()))
                {
                    movingInjection = true;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if(!gameOver && movingInjection)
                {
                    injectionPoint.set((int) event.getX(), (int) event.getY());
                }
                break;
            case MotionEvent.ACTION_UP:
                movingInjection = false;
                break;
        }

        return true;
        //return super.onTouchEvent(event);
    }

    public void update()
    {
        if(!gameOver)
        {
            injection.update(injectionPoint);
            injectionBody.update();
        }

        if(injectionBody.injectionCollide(injection))
        {
            gameOver = true;
        }
    }

    @Override
    public void draw(Canvas canvas)
    {
        super.draw(canvas);

        canvas.drawColor(Color.WHITE);

        injection.draw(canvas);
        injectionBody.draw(canvas);

        if(gameOver)
        {
            Paint paint = new Paint();
            paint.setTextSize(100);
            paint.setColor(Color.MAGENTA);
            paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText("WELL DONE!", InjectionConstants.SCREEN_WIDTH/2, InjectionConstants.SCREEN_HEIGHT/2, paint);
        }
    }
}
