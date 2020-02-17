package com.hummer.educationalgame.CreamMinigame;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

import com.hummer.educationalgame.R;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private MainThread thread;
    private CharacterArmSprite characterArmSprite;
    private HospitalBackground b1;
    private int xOfScreen, yOfScreen;
//    private float screenRatioX, screenRatioY;

    public GameView(Context context, int xOfScreen, int yOfScreen) {
        super(context);

        this.xOfScreen = xOfScreen;
        this.yOfScreen = yOfScreen;
//        screenRatioX = 1024f / xOfScreen;
//        screenRatioY = 600f / yOfScreen;

        getHolder().addCallback(this);

        thread = new MainThread(getHolder(), this);
        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        b1 = new HospitalBackground(xOfScreen, yOfScreen, getResources());
        characterArmSprite = new CharacterArmSprite(xOfScreen, yOfScreen, getResources());
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while(retry) {
            try {
                thread.setRunning(false);
                thread.join();
            } catch(InterruptedException ex) {
                ex.printStackTrace();
            }
            retry = false;
        }
    }

    public void update() {
        characterArmSprite.update();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if(canvas != null) {
            b1.draw(canvas);
            characterArmSprite.draw(canvas);
        }
    }

    private void sleep() {
        try {
            Thread.sleep(17);
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // User input stuff goes here
        int X = (int) event.getX();
        int Y = (int) event.getY();
        int eventAction = event.getAction();

        return true;
    }
}
