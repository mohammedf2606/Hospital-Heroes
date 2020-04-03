package com.hummer.hospital_heroes.milk_minigame;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.hummer.hospital_heroes.Constants;
import com.hummer.hospital_heroes.R;
import com.hummer.hospital_heroes.food_minigame.Bowl;
import com.hummer.hospital_heroes.plate_minigame.PlateActivity;

public class MilkGameView extends SurfaceView implements SurfaceHolder.Callback {
    private Context mContext;
    private MilkMainThread thread;
    private MilkCarton milk;
    private Bowl bowl;
    private Bitmap background;
    private Bitmap sticker;
    static int score = 0;

    public MilkGameView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        this.mContext = context;
        getHolder().addCallback(this);
        thread = new MilkMainThread(getHolder(), this);
        setFocusable(true);
        System.out.println("Milk created");
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        int width = Constants.SCREEN_WIDTH;
        int height = Constants.SCREEN_HEIGHT;
        bowl = new Bowl(BitmapFactory.decodeResource(getResources(), R.drawable.bowl), width, height);
        milk = new MilkCarton(BitmapFactory.decodeResource(getResources(), R.drawable.milk2),
                BitmapFactory.decodeResource(getResources(), R.drawable.milk_droplet));
        background = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.background_food), width, height,false);
        sticker = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.sticker), 300, 300,false);

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
            milk.update(bowl.getX(), bowl.getY());
        }
    }

    private void updateFrame(int newX, int newY) {
        if (score < 4 && newX > 125 && newX < Constants.SCREEN_WIDTH - 125) {
            bowl.update(newX - 125, newY);
        }
    }

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        if(canvas != null){
            canvas.drawBitmap(background, 0, 0, null);
            bowl.draw(canvas);
            milk.drawFood(canvas);

            if (score >= 3) {
                //Bitmap sticker = BitmapFactory.decodeResource(getResources(), R.drawable.sticker_gif);
                //EndSticker endSticker = new EndSticker(sticker, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
                //endSticker.draw(canvas);

                canvas.drawBitmap(sticker, 0, 0, null);

                try {
                    thread.sleep(3000);
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
