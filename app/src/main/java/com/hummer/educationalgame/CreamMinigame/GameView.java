package com.hummer.educationalgame.CreamMinigame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private MainThread thread;
    private CharacterArmSprite characterArmSprite;
    private HospitalBackground b1;
    private CreamTubeSprite creamTube;
    private CreamApplicationLocation location1, location2;
    private CreamSplatter1 splat1;
    private CreamSplatter2 splat2;
    private CreamSplatter3 splat3;
    private int xOfScreen, yOfScreen;
    private Canvas canvas;
    private int xCoord, yCoord;
    private Path path;
    private Paint paint;
    private boolean isTouchingScreen;
    private int progress1, progress2;
    private boolean partiallyAppliedCreamOnPos1, considerablyAppliedCreamOnPos1, fullyAppliedCreamOnPos1;
    private boolean partiallyAppliedCreamOnPos2, considerablyAppliedCreamOnPos2, fullyAppliedCreamOnPos2;
//    private float screenRatioX, screenRatioY;

    public GameView(Context context, int xOfScreen, int yOfScreen) {
        super(context);

        this.xOfScreen = xOfScreen;
        this.yOfScreen = yOfScreen;
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
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(10);
        path = new Path();
        b1 = new HospitalBackground(xOfScreen, yOfScreen, getResources());
        characterArmSprite = new CharacterArmSprite(xOfScreen, yOfScreen, getResources());
        location1 = new CreamApplicationLocation(xOfScreen/8 - 20, yOfScreen/3 + 50, getResources());
        location2 = new CreamApplicationLocation(xOfScreen/2 + 100, yOfScreen/3 + 60, getResources());
        creamTube = new CreamTubeSprite(getResources());
        splat1 = new CreamSplatter1(getResources());
        splat2 = new CreamSplatter2(getResources());
        splat3 = new CreamSplatter3(getResources());
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
        if(Rect.intersects(location1.getHitbox(), creamTube.getHitbox()) && isTouchingScreen == true) {
            progress1++;
            switch(progress1) {
                case 100: partiallyAppliedCreamOnPos1 = true;
                break;
                case 200: considerablyAppliedCreamOnPos1 = true;
                break;
                case 300: fullyAppliedCreamOnPos1 = true;
                break;
            }
        } else if(Rect.intersects(location2.getHitbox(), creamTube.getHitbox()) && isTouchingScreen == true) {
            progress2++;
            switch(progress2) {
                case 100: partiallyAppliedCreamOnPos2 = true;
                break;
                case 200: considerablyAppliedCreamOnPos2 = true;
                break;
                case 300: fullyAppliedCreamOnPos2 = true;
                break;
            }
        }
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.canvas = canvas;
        if(canvas != null) {

            b1.draw(canvas);
            characterArmSprite.draw(canvas);
            location1.draw(canvas);
            location2.draw(canvas);

            if(fullyAppliedCreamOnPos1) {
                splat1.draw(canvas, xOfScreen/8 - 20, yOfScreen/3 + 50);
            } else if(considerablyAppliedCreamOnPos1) {
                splat2.draw(canvas, xOfScreen/8 - 20, yOfScreen/3 + 50);
            } else if(partiallyAppliedCreamOnPos1) {
                splat3.draw(canvas,  xOfScreen/8 - 20, yOfScreen/3 + 50);
            }

            if(fullyAppliedCreamOnPos2) {
                splat1.draw(canvas, xOfScreen/2 + 100, yOfScreen/3 + 60);
            } else if(considerablyAppliedCreamOnPos2) {
                splat2.draw(canvas, xOfScreen/2 + 100, yOfScreen/3 + 60);
            } else if(partiallyAppliedCreamOnPos2) {
                splat3.draw(canvas,  xOfScreen/2 + 100, yOfScreen/3 + 60);
            }

            if(!(xCoord == 0 || yCoord == 0)) {
                int x2 = xCoord;
                int y2 = yCoord - creamTube.getHeight();
                creamTube.draw(canvas, x2, y2);
                canvas.drawCircle(x2, yCoord, 5, paint);
            }
            canvas.drawPath(path, paint);
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
                    path.moveTo(X, Y);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (X >= characterArmSprite.getX() && X < (characterArmSprite.getX() + characterArmSprite.getWidth())
                        && Y >= characterArmSprite.getY() && Y < (characterArmSprite.getY() + characterArmSprite.getHeight())) {
                    xCoord = X;
                    yCoord = Y;
                    path.moveTo(X, Y);
                }
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
