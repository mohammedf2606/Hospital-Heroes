package com.hummer.educationalgame.foodminigame;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

import com.hummer.educationalgame.R;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread;
    private FoodSprite foodSprite;

    public GameView(Context context){
        super(context);
        getHolder().addCallback(this);

        thread = new MainThread(getHolder(), this);
        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        foodSprite = new FoodSprite(BitmapFactory.decodeResource(getResources(), R.drawable.hashbrown));
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
        foodSprite.update();
    }

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        if(canvas != null){
            foodSprite.draw(canvas);
        }
    }
}
