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

/**
 * InjectionGamePanel is the class of the game that represents the game panel. It builds
 * and displays the game panel and initialises all other components.
 *
 * @author Fareed Faisal
 * @version 1.0
 */
public class InjectionGamePanel extends SurfaceView implements SurfaceHolder.Callback
{
    private InjectionMainThread thread;

    private InjectionSceneManager manager;

    public InjectionGamePanel(Context context)
    {
        super(context);

        getHolder().addCallback(this);

        InjectionConstants.CURRENT_CONTEXT = context;

        thread = new InjectionMainThread(getHolder(), this);

        manager = new InjectionSceneManager(context);

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
        manager.receiveTouch(event);

        return true;
        //return super.onTouchEvent(event);
    }

    public void update()
    {
        manager.update();
    }

    @Override
    public void draw(Canvas canvas)
    {
        super.draw(canvas);

        manager.draw(canvas);
    }
}
