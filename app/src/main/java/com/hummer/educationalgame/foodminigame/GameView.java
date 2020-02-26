package com.hummer.educationalgame.foodminigame;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

import com.hummer.educationalgame.Constants;
import com.hummer.educationalgame.R;

import java.util.ArrayList;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;
    private FoodSprite foodSprite;
    private Bowl bowl;

    public GameView(Context context){
        super(context);
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        int width = Resources.getSystem().getDisplayMetrics().widthPixels;
        int height = Resources.getSystem().getDisplayMetrics().heightPixels;
        bowl = new Bowl(BitmapFactory.decodeResource(getResources(), R.drawable.bowl), width, height);
        foodSprite = new FoodSprite(BitmapFactory.decodeResource(getResources(), R.drawable.hashbrown2), BitmapFactory.decodeResource(getResources(), R.drawable.beans));
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
        foodSprite.update(bowl.getX());
    }

    private void updateFrame(int newX, int newY) {
        if (newX > 125 && newX < Constants.SCREEN_WIDTH - 125) {
            bowl.update(newX - 125, newY);
        }
    }

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        if(canvas != null){
            bowl.draw(canvas);
            foodSprite.drawHashBrown(canvas);
            foodSprite.drawBeans(canvas);

        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        // Invalidate() is inside the case statements because there are
        // many other motion events, and we don't want to invalidate
        // the view for those.
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                updateFrame((int) x, (int) y);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                updateFrame((int) x, (int) y);
                invalidate();
                break;
            default:
                // Do nothing.
        }
        return true;
    }
}
