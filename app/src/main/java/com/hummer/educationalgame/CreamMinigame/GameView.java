package com.hummer.educationalgame.CreamMinigame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

import com.hummer.educationalgame.R;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private MainThread thread;
    private CharacterArmSprite characterArmSprite;
    private HospitalBackground b1;
    private CreamSprite splat;
//    private CreamSprite splat;
    private int xOfScreen, yOfScreen;
    private Canvas canvas;
    private int xCoord, yCoord;
    private Path path;
    private Paint paint;
    private boolean isTouchingScreen = false;
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
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(10);
        path = new Path();
        b1 = new HospitalBackground(xOfScreen, yOfScreen, getResources());
        characterArmSprite = new CharacterArmSprite(xOfScreen, yOfScreen, getResources());
        splat = new CreamSprite(getResources());
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
        System.out.println("running");
        if(Rect.intersects(characterArmSprite.getHitbox(), splat.getHitbox()) && isTouchingScreen == true) {
            System.out.println("they are touching");

        }
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.canvas = canvas;
        if(canvas != null) {
            b1.draw(canvas);
            characterArmSprite.draw(canvas);
            if(!(xCoord == 0 || yCoord == 0)) {
                int x2 = xCoord;
                int y2 = yCoord - splat.getHeight();
                splat.draw(canvas, x2, y2);
                canvas.drawCircle(x2, yCoord, 5, paint);
            }
            canvas.drawPath(path, new Paint());
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
                    isTouchingScreen = true;
                    xCoord = X;
                    yCoord = Y;
                    path.moveTo(X, Y);}
                break;
            case MotionEvent.ACTION_MOVE:
                if (X >= characterArmSprite.getX() && X < (characterArmSprite.getX() + characterArmSprite.getWidth())
                        && Y >= characterArmSprite.getY() && Y < (characterArmSprite.getY() + characterArmSprite.getHeight())) {
                    xCoord = X;
                    yCoord = Y;
                    path.moveTo(X, Y);}
                break;
            case MotionEvent.ACTION_UP:
                xCoord = 0;
                yCoord = 0;
                isTouchingScreen = false;
                break;
        }
        return true;
    }
}
