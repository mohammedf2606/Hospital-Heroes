package com.hummer.educationalgame.rocketminigame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

import com.hummer.educationalgame.SoundEffects;

/**
 * GameView represents the powerhouse class of the package. All
 * the processes and logic are processed here, including drawing bitmaps,
 * checking conditions and evaluating expressions.
 *
 * @author Jawad Zeidan, Fahim Mohammed
 * @version 1.0
 */

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private MainThread thread;
    private GameActivity gameActivity;
    private Canvas canvas;
    private int xOfScreen, yOfScreen;
    private boolean soundPlayedAlready, isTouchingScreen;
    private StarBackground starBackground;
    private RocketSprite rocket;
    private HouseSprite house;
    private AsteroidManager asteroidManager;
    private int xCoord, yCoord;

    public GameView(Context context, int xOfScreen, int yOfScreen) {
        super(context);

        this.xOfScreen = xOfScreen;
        this.yOfScreen = yOfScreen;
        getHolder().addCallback(this);

        starBackground = new StarBackground(xOfScreen, yOfScreen, getResources());
        rocket = new RocketSprite(getResources());
        house = new HouseSprite(getResources());
        asteroidManager = new AsteroidManager(getResources());


        thread = new MainThread(getHolder(), this);
        setFocusable(true);

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
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

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.canvas = canvas;
        if(canvas != null) {
            starBackground.draw(canvas);
            house.draw(xOfScreen - xOfScreen/4 + 30, yOfScreen/2 + house.getHeight()/2 - 20, canvas);
            rocket.draw(xOfScreen/16, yOfScreen/4 - rocket.getHeight(), canvas);
            asteroidManager.draw(canvas);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // User input stuff goes here
        int X = (int) event.getX();
        int Y = (int) event.getY();
        int eventAction = event.getAction();

        switch(eventAction){
            case MotionEvent.ACTION_DOWN:
//                if (X >= characterArmSprite.getX() && X < (characterArmSprite.getX() + characterArmSprite.getWidth())
//                        && Y >= characterArmSprite.getY() && Y < (characterArmSprite.getY() + characterArmSprite.getHeight())) {
                    // stuff for making cream appear here
                    isTouchingScreen = true;
                    xCoord = X;
                    yCoord = Y;
//                }
                break;
            case MotionEvent.ACTION_MOVE:
//                if (X >= characterArmSprite.getX() && X < (characterArmSprite.getX() + characterArmSprite.getWidth())
//                        && Y >= characterArmSprite.getY() && Y < (characterArmSprite.getY() + characterArmSprite.getHeight())) {
                    xCoord = X;
                    yCoord = Y;
//                }
                break;
            case MotionEvent.ACTION_UP:
                xCoord = 0;
                yCoord = 0;
                isTouchingScreen = false;
                break;
        }
        return true;
    }

    public void setGameActivity(GameActivity activity) {
        gameActivity = activity;
    }

    public void playVictorySound() {
        soundPlayedAlready = true;
        SoundEffects.playSound(0);
    }
}