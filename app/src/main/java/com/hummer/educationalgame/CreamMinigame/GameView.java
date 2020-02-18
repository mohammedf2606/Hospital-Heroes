package com.hummer.educationalgame.CreamMinigame;

import android.content.Context;
import android.graphics.Bitmap;
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
//    private CreamSprite splat;
    private int xOfScreen, yOfScreen;
    private Canvas canvas;
    private int xCoord, yCoord;
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
//        splat = new CreamSprite(xOfScreen, yOfScreen, getResources());
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
        this.canvas = canvas;
        super.draw(canvas);
        if(canvas != null) {
            b1.draw(canvas);
            characterArmSprite.draw(canvas);
            CreamSprite splat = new CreamSprite(0,0, getResources());
            splat.draw(canvas, xCoord-50, yCoord-50);
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

        switch(eventAction){
            case MotionEvent.ACTION_DOWN:
                if (X >= characterArmSprite.getX() && X < (characterArmSprite.getX() + characterArmSprite.getWidth())
                        && Y >= characterArmSprite.getY() && Y < (characterArmSprite.getY() + characterArmSprite.getHeight())) {
                    // stuff for making cream appear here
                    xCoord = X;
                    yCoord = Y;
                    System.out.println(xCoord);
                    System.out.println(yCoord);
//                    CreamSprite splat = new CreamSprite(xCoord, yCoord, getResources());
//                    drawBitmap(splat.getBitmap(), xCoord, yCoord);
//                    System.out.println("Touched hand");
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (X >= characterArmSprite.getX() && X < (characterArmSprite.getX() + characterArmSprite.getWidth())
                        && Y >= characterArmSprite.getY() && Y < (characterArmSprite.getY() + characterArmSprite.getHeight())) {
                    xCoord = X;
                    yCoord = Y;
                }
        }
        return true;
    }

    public void drawBitmap(Bitmap bmp, int x, int y) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(3);
        canvas.drawCircle(100, 100, 5, paint);
    }

}
