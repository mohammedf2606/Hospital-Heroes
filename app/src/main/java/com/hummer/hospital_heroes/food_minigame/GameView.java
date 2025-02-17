package com.hummer.hospital_heroes.food_minigame;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;
import com.hummer.hospital_heroes.Constants;
import com.hummer.hospital_heroes.R;
import com.hummer.hospital_heroes.SoundEffects;
import com.hummer.hospital_heroes.cream_minigame.EndGameSticker;
import com.hummer.hospital_heroes.plate_minigame.PlateActivity;

import java.util.ArrayList;

/**
 * GameView is the surface view for the food mini game
 *
 * @author Manav Parikh
 * @version 1.0
 */
public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private Context mContext;
    private MainThread thread;
    private FoodSprite hashbrown;
    private FoodSprite beans;
    private Bowl bowl;
    private Bitmap background;
    private int width, height;
    private Canvas canvas;
    static int score = 0;
    private EndGameSticker sticker;
    private boolean victorySoundPlayedAlready = false;


    /**
     * The constructor for the class. Starts a new thread for the game loop.
     * @param context the current Context
     */
    public GameView(Context context){
        super(context);
        this.mContext = context;
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        setFocusable(true);
    }

    /**
     * Initialises required objects when surface is created
     * @param holder The SurfaceHolder containing GameView
     */
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        this.width = Constants.SCREEN_WIDTH; //1024
        this.height = Constants.SCREEN_HEIGHT; //600
        bowl = new Bowl(BitmapFactory.decodeResource(getResources(), R.drawable.bowl), width, height);
        hashbrown = new FoodSprite(BitmapFactory.decodeResource(getResources(), R.drawable.hashbrown), false);
        beans = new FoodSprite(BitmapFactory.decodeResource(getResources(), R.drawable.beans), true);
        background = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.background_food), width, height,false);
        sticker = new EndGameSticker(width, height, getResources());
        sticker.setSpeed(6);

        thread.start();
        thread.setRunning(true);
        
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    /**
     * Update method. Updates hashbrown and beans if game isn't over
     */
    public void update() {
        if (score < 11) {
            hashbrown.update(bowl.getX(), bowl.getY());
            beans.update(bowl.getX(), bowl.getY());
        }
    }

    /**
     * Updates bowl with its new coordinates
     * @param newX new X coordinate to move to
     * @param newY new Y coordinate to move to
     */
    private void updateFrame(int newX, int newY) {
        if (score < 11 && newX > 125 && newX < Constants.SCREEN_WIDTH - 125) {
            bowl.update(newX - 125, newY);
        }
    }

    /**
     * Plays victory sound
     */
    public void playVictorySound() {
        victorySoundPlayedAlready = true;
        SoundEffects.playSound(0);
    }

    /**
     * Draws every element of the game onto the canvas, called every tick. When the game ends,
     * draws a sticker and plays a chime
     * @param canvas The Canvas to draw on
     */
    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        this.canvas = canvas;
        if(canvas != null){
            if (score >= 10) {
                Paint p = new Paint(Color.RED);
                ColorFilter filter = new LightingColorFilter(0xFF7F7F7F, 0x00000000);    // darken
                p.setColorFilter(filter);
                canvas.drawBitmap(background, 0, 0, p);

                int value = sticker.drawAnimation(canvas);
                if(!victorySoundPlayedAlready) {
                    playVictorySound();
                }
                if(value == sticker.getWidth()) {
                    Intent plate_activity = new Intent(mContext, PlateActivity.class);
                    mContext.startActivity(plate_activity);
                    thread.setRunning(false);
                }

            } else {
                canvas.drawBitmap(background, 0, 0, null);
                bowl.draw(canvas);
                hashbrown.drawFood(canvas);
                beans.drawFood(canvas);
            }
        }
    }

    /**
     * Moves bowl whenever a drag or tap is executed on the screen
     * @param event The MotionEvent that occurred
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

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

    /**
     * Returns the resolution of the screen as an arraylist
     */
    public ArrayList getResolution() {
        ArrayList<Integer> reso = new ArrayList<Integer>();
        reso.add(width);
        reso.add(height);
        return reso;
    }

    /**
     * Finishes the game by setting its victory conditions to true
     */
    public void finishGame() {
        score = 10;
    }

    /**
     * This method returns the value of the boolean 'victorySoundPlayedAlready'
     * @return victorySoundPlayedAlready the boolean that determines whether
     * the sound has been played already or not
     */
    public boolean isVictorySoundPlayedAlready() {
        return victorySoundPlayedAlready;
    }

    /**
     * This method returns the canvas of the game
     * @return canvas the canvas the game is being painted onto
     */
    public Canvas getCanvas() {
        return canvas;
    }

    /**
     * This method returns the endgame sticker that appears
     * @return sticker the endgame sticker
     */
    public EndGameSticker getSticker() {
        return sticker;
    }

    /**
     * Returns all the bitmaps in the game as an arraylist
     */
    public ArrayList getBitmaps() {
        ArrayList<Bitmap> bitmaps = new ArrayList<>();
        bitmaps.add(bowl.getBitmap());
        bitmaps.add(hashbrown.getBitmap());
        bitmaps.add(beans.getBitmap());
        bitmaps.add(background);
        bitmaps.add(sticker.getBitmap());
        return bitmaps;
    }

}
