package com.hummer.educationalgame.injectionminigame;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.hummer.educationalgame.SoundEffects;

/**
 * InjectionGameplayScene is the class of the game that represents the gameplay scene. It builds
 * and displays the gameplay scene and intialises all other components.
 *
 * @author Fareed Faisal
 * @version 1.0
 */
public class InjectionGameplayScene implements InjectionScene
{
    private Injection injection;
    private Point injectionPoint;
    private InjectionBody injectionBody;

    private boolean movingInjection = false;

    private boolean gameOver = false;

    public InjectionGameplayScene()
    {
        injection = new Injection(new Rect(100,100,200,200), Color.rgb(255,0,0));
        injectionPoint = new Point(3*InjectionConstants.SCREEN_WIDTH/4, InjectionConstants.SCREEN_HEIGHT/4);
        injection.update(injectionPoint);

        injectionBody = new InjectionBody(new Rect(200,200,400,400), Color.BLACK);

    }

    @Override
    public void terminate()
    {
        InjectionSceneManager.ACTIVE_SCENE = 0;
    }

    @Override
    public void receiveTouch(MotionEvent event)
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
    }

    @Override
    public void draw(Canvas canvas)
    {
        canvas.drawColor(Color.WHITE);

        injection.draw(canvas);
        injectionBody.draw(canvas);

        if(gameOver)
        {
            endGame(canvas);
        }
    }

    private static void endGame(Canvas canvas) {
        Paint paint = new Paint();
        paint.setTextSize(100);
        paint.setColor(Color.MAGENTA);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("WELL DONE!", InjectionConstants.SCREEN_WIDTH/2, InjectionConstants.SCREEN_HEIGHT/2, paint);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
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

}
