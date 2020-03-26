package com.hummer.hospital_heroes.food_minigame;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.widget.ImageView;

//import com.bumptech.glide.Glide;
import com.hummer.hospital_heroes.Constants;
import com.hummer.hospital_heroes.R;
import com.hummer.hospital_heroes.plate_minigame.PlateActivity;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private Context mContext;
    private MainThread thread;
    private FoodSprite hashbrown;
    private FoodSprite beans;
    private Bowl bowl;
    private ImageView imageView;
    static int score = 0;

    public GameView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        this.mContext = context;
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        int width = Resources.getSystem().getDisplayMetrics().widthPixels;
        int height = Resources.getSystem().getDisplayMetrics().heightPixels;
        bowl = new Bowl(BitmapFactory.decodeResource(getResources(), R.drawable.bowl), width, height);
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
        if (score < 11) {
            hashbrown.update(bowl.getX(), bowl.getY());
            beans.update(bowl.getX(), bowl.getY());
        }
    }

    private void updateFrame(int newX, int newY) {
        if (score < 11 && newX > 125 && newX < Constants.SCREEN_WIDTH - 125) {
            bowl.update(newX - 125, newY);
        }
    }

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        if(canvas != null){
            bowl.draw(canvas);
            hashbrown.drawFood(canvas);
            beans.drawFood(canvas);

            if (score >= 10) {
                //Bitmap sticker = BitmapFactory.decodeResource(getResources(), R.drawable.sticker_gif);
                //EndSticker endSticker = new EndSticker(sticker, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
                //endSticker.draw(canvas);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent plate_activity = new Intent(mContext, PlateActivity.class);
                mContext.startActivity(plate_activity);
                thread.setRunning(false);
            }
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
