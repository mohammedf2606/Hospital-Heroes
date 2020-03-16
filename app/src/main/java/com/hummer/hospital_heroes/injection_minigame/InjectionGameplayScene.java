package com.hummer.hospital_heroes.injection_minigame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;

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

        sticker = new InjectionGameOver(4 * InjectionConstants.SCREEN_WIDTH/4, 4 * InjectionConstants.SCREEN_HEIGHT/4, context.getResources());

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
                System.out.println("no u");
                gameActivity.nextScene();
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

    public void setGameActivity(InjectionMainActivity gameActivity) {
        this.gameActivity = gameActivity;
    }
}
