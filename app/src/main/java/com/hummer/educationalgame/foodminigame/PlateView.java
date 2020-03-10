package com.hummer.educationalgame.foodminigame;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ImageView;

import com.hummer.educationalgame.Constants;
import com.hummer.educationalgame.R;
import com.hummer.educationalgame.WaitingRoom;

public class PlateView extends SurfaceView implements SurfaceHolder.Callback {
    private Context mContext;
    private PlateMainThread thread;
    private PlateFood plateFood;

    public PlateView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        this.mContext = context;
        getHolder().addCallback(this);
        thread = new PlateMainThread(getHolder(), this);
        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        int width = Resources.getSystem().getDisplayMetrics().widthPixels;
        int height = Resources.getSystem().getDisplayMetrics().heightPixels;
        plateFood = new PlateFood(BitmapFactory.decodeResource(getResources(), R.drawable.beans));

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
        plateFood.update();
    }

    private void updateFrame(int newX, int newY) {

    }

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        if(canvas != null){
            plateFood.drawFood(canvas);
//            if (score >= 10) {
//                try {
//                    thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                Intent waiting_room = new Intent(mContext, WaitingRoom.class);
//                mContext.startActivity(waiting_room);
//            }
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
