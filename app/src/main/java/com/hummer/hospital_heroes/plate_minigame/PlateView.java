package com.hummer.hospital_heroes.plate_minigame;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.hummer.hospital_heroes.FoodSelection;
import com.hummer.hospital_heroes.PreScan;
import com.hummer.hospital_heroes.R;

/**
 * PlateView is the surface view for the plate mini game which runs after the food/milk games. It
 * cycles through images which depict food/milk being consumed.
 *
 * @author Manav Parikh
 * @version 1.0
 */
public class PlateView extends SurfaceView implements SurfaceHolder.Callback {
    private Context mContext;
    private PlateFood plateFood;
    private boolean milk;

    /**
     * The constructor for the class.
     * @param context the current Context
     */
    public PlateView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        this.mContext = context;
        getHolder().addCallback(this);
        setFocusable(true);
        milk = FoodSelection.isMilk;
    }

    /**
     * Initialises required objects when surface is created. The milk boolean is set in the food
     * selection activity and determines what images are chosen.
     * @param holder The SurfaceHolder containing PlateView
     */
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if(milk) {
            plateFood = new PlateFood(BitmapFactory.decodeResource(getResources(), R.drawable.platemilk0),
                    BitmapFactory.decodeResource(getResources(), R.drawable.platemilk1),
                    BitmapFactory.decodeResource(getResources(), R.drawable.platemilk2),
                    BitmapFactory.decodeResource(getResources(), R.drawable.platemilk3),
                    BitmapFactory.decodeResource(getResources(), R.drawable.food4));
        } else {
            plateFood = new PlateFood(BitmapFactory.decodeResource(getResources(), R.drawable.food0),
                    BitmapFactory.decodeResource(getResources(), R.drawable.food1),
                    BitmapFactory.decodeResource(getResources(), R.drawable.food2),
                    BitmapFactory.decodeResource(getResources(), R.drawable.food3),
                    BitmapFactory.decodeResource(getResources(), R.drawable.food4));
        }
        
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
    }

    /**
     * Update method. Updates the plate.
     */
    public void update() {
        plateFood.update();
    }

    /**
     * Draws every element of the game onto the canvas, called every tick. When the game ends,
     * advances to the next activity
     * @param canvas The Canvas to draw on
     */
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

    /**
     * Updates the plate when the screen is tapped
     * @param event The MotionEvent that occurred
     */
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
