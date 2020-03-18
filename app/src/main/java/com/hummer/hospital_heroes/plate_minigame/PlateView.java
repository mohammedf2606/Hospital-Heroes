package com.hummer.hospital_heroes.plate_minigame;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.hummer.hospital_heroes.PreScan;
import com.hummer.hospital_heroes.R;

public class PlateView extends SurfaceView implements SurfaceHolder.Callback {
    private Context mContext;
    private PlateFood plateFood;

    public PlateView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        this.mContext = context;
        getHolder().addCallback(this);
        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        plateFood = new PlateFood(BitmapFactory.decodeResource(getResources(), R.drawable.food0),
                BitmapFactory.decodeResource(getResources(), R.drawable.food1),
                BitmapFactory.decodeResource(getResources(), R.drawable.food2),
                BitmapFactory.decodeResource(getResources(), R.drawable.food3),
                BitmapFactory.decodeResource(getResources(), R.drawable.food4));
        
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

    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        if(canvas != null){
            if (plateFood.drawFood(canvas)) {
                Intent waiting_room = new Intent(mContext, PreScan.class);
                mContext.startActivity(waiting_room);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                update();
                invalidate();
                break;
            default:
                // Do nothing.
        }
        return true;
    }
}
