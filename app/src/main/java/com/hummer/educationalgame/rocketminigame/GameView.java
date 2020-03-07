package com.hummer.educationalgame.rocketminigame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
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
    private int xOfScreen, yOfScreen;
    private boolean soundPlayedAlready, isTouchingScreen, gameFinished;
    private StarBackground starBackground;
    private RocketSprite rocket;
    private HouseSprite house;
    private EndGameSticker sticker;
    private AsteroidManager asteroidManager;
    private int xCoord, yCoord;
    private boolean reset = true;

    public GameView(Context context, int xOfScreen, int yOfScreen) {
        super(context);

        this.xOfScreen = xOfScreen;
        this.yOfScreen = yOfScreen;
        getHolder().addCallback(this);

        starBackground = new StarBackground(xOfScreen, yOfScreen, getResources());
        rocket = new RocketSprite(getResources());
        house = new HouseSprite(getResources());
        asteroidManager = new AsteroidManager(getResources());
        sticker = new EndGameSticker(xOfScreen, yOfScreen, getResources());

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
        if(Rect.intersects(rocket.getHitbox(), asteroidManager.asteroids.get(0).getHitbox())){
            reset = true;
        }
        else if(Rect.intersects(rocket.getHitbox(), asteroidManager.asteroids.get(1).getHitbox())){
            reset = true;
        }
        else if(Rect.intersects(rocket.getHitbox(), asteroidManager.asteroids.get(2).getHitbox())){
            reset = true;
        }
        else if(Rect.intersects(rocket.getHitbox(), house.getHitBox())){
            gameFinished = true;
        }
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if(canvas != null && reset) {
            starBackground.draw(canvas);
            house.draw(xOfScreen - xOfScreen/4 + 30, yOfScreen/2 + house.getHeight()/2 - 20, canvas);
            rocket.draw(xOfScreen/16, yOfScreen/4 - rocket.getHeight(), canvas);
            asteroidManager.draw(canvas);
            reset = false;
        }
        else if(canvas != null){
            starBackground.draw(canvas);
            house.draw(xOfScreen - xOfScreen/4 + 30, yOfScreen/2 + house.getHeight()/2 - 20, canvas);
            rocket.draw(xCoord, yCoord, canvas);
            asteroidManager.draw(canvas);
            if(gameFinished) {
                starBackground.drawDarkenedImage(canvas);
                int value = sticker.drawAnimation(canvas);
                if(!soundPlayedAlready) {
                    playVictorySound();
                }
                if(value == sticker.getWidth()){
                    gameActivity.nextScene();
                }
            }
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