package com.hummer.educationalgame.injectionminigame;

<<<<<<< HEAD
import android.content.Context;
=======
import android.app.Activity;
import android.content.Intent;
>>>>>>> 1ad2b40d3fc71b0d315b9c64827f803a55e93d36
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.hummer.educationalgame.PreScan;

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

    private InjectionMainActivity gameActivity;
    private InjectionGameOver sticker;

    public InjectionGameplayScene(Context context)
    {
        injection = new Injection(new Rect(100,100,200,200), Color.rgb(255,0,0));
        injectionPoint = new Point(3*InjectionConstants.SCREEN_WIDTH/4, InjectionConstants.SCREEN_HEIGHT/4);
        injection.update(injectionPoint);

        injectionBody = new InjectionBody(new Rect(200,200,400,400), Color.BLACK);

        sticker = new InjectionGameOver(InjectionConstants.SCREEN_WIDTH/2, InjectionConstants.SCREEN_HEIGHT/2, context.getResources());

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
    public void draw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);

        injection.draw(canvas);
        injectionBody.draw(canvas);

        if (gameOver) {
            Paint paint = new Paint();
            paint.setTextSize(100);
            paint.setColor(Color.MAGENTA);
            paint.setTextAlign(Paint.Align.CENTER);
            int value = sticker.drawAnimation(canvas);
            if (value == 400) {

            }
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
