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
    private HospitalBackground b1, b2;

    public GameView(Context context) {
        super(context);

//        b1 = new HospitalBackground(xOfScreen, yOfScreen, getResources());

        getHolder().addCallback(this);

        thread = new MainThread(getHolder(), this);
        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        characterArmSprite = new CharacterArmSprite(BitmapFactory.decodeResource(getResources(), R.drawable.arm));
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
            characterArmSprite.draw(canvas);
        }
    }

//    @Override
//    public void draw(Canvas canvas) {
//        super.draw(canvas);
//        if (canvas != null) {
//            canvas.drawColor(Color.WHITE);
//            Paint paint = new Paint();
//            paint.setColor(Color.rgb(250, 0, 0));
//            canvas.drawRect(100, 100, 200, 200, paint);
//        }
//    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // User input stuff goes here
        int X = (int) event.getX();
        int Y = (int) event.getY();
        int eventAction = event.getAction();

        return true;
    }
}
