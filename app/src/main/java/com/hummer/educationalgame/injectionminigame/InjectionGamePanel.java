package com.hummer.educationalgame.injectionminigame;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.provider.SyncStateContract;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.hummer.educationalgame.MainMenu;
import com.hummer.educationalgame.PreScan;
import com.hummer.educationalgame.R;

/**
 * InjectionGamePanel is the class of the game that represents the game panel. It builds
 * and displays the game panel and initialises all other components.
 *
 * @author Fareed Faisal
 * @version 1.0
 */
public class InjectionGamePanel extends SurfaceView implements SurfaceHolder.Callback {
    private Context mContext;
    private InjectionMainThread thread;
    private Injection injection;
    private Point injectionPoint;
    private InjectionBody injectionBody;
    private boolean movingInjection = false;
    private boolean gameOver = false;
    private long gameOverTime;
    private InjectionMainActivity gameActivity;
    private InjectionGameOver sticker;

    public InjectionGamePanel(Context context) {
        super(context);
        this.mContext = context;
        InjectionConstants.CURRENT_CONTEXT = this.mContext;
        getHolder().addCallback(this);
        thread = new InjectionMainThread(getHolder(), this);
        injection = new Injection(new Rect(100, 100, 200, 200), Color.rgb(255, 0, 0));
        injectionPoint = new Point(3 * InjectionConstants.SCREEN_WIDTH / 4, InjectionConstants.SCREEN_HEIGHT / 4);
        injection.update(injectionPoint);
        injectionBody = new InjectionBody(new Rect(200, 200, 400, 400), Color.BLACK);
        sticker = new InjectionGameOver(4 * InjectionConstants.SCREEN_WIDTH / 4, 4 * InjectionConstants.SCREEN_HEIGHT / 4, context.getResources());
        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new InjectionMainThread(getHolder(), this);

        int width = Resources.getSystem().getDisplayMetrics().widthPixels;
        int height = Resources.getSystem().getDisplayMetrics().heightPixels;
        injection = new Bowl(BitmapFactory.decodeResource(getResources(), R.drawable.), width, height);
        hashbrown = new FoodSprite(BitmapFactory.decodeResource(getResources(), R.drawable.hashbrown2), false);
        beans = new FoodSprite(BitmapFactory.decodeResource(getResources(), R.drawable.beans), true);

        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    public void update() {
        injection.update(injectionPoint);
        injectionBody.update();
        if (!gameOver) {
            injection.update(injectionPoint);
            injectionBody.update();
        }
        if (injectionBody.injectionCollide(injection)) {
            gameOver = true;
            gameOverTime = System.currentTimeMillis();
        }
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (canvas != null) {
            canvas.drawColor(Color.WHITE);
            injection.draw(canvas);
            injectionBody.draw(canvas);
            if (gameOver) {
                //  Paint paint = new Paint();
                //  paint.setTextSize(100);
                //  paint.setColor(Color.MAGENTA);
                //  paint.setTextAlign(Paint.Align.CENTER);
                int value = sticker.drawAnimation(canvas);
                if (value == 400)
                {
                try {
                    thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent nextScene = new Intent(mContext, PreScan.class);
                mContext.startActivity(nextScene);
                }
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (!gameOver && injection.getInjection().contains((int) event.getX(), (int) event.getY())) {
                    movingInjection = true;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (!gameOver && movingInjection) {
                    injectionPoint.set((int) event.getX(), (int) event.getY());
                }
                break;
            case MotionEvent.ACTION_UP:
                movingInjection = false;
                break;
        }
        return true;
    }
}
