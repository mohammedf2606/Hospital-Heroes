package com.hummer.hospital_heroes.rocket_minigame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

import com.hummer.hospital_heroes.SoundEffects;
import com.hummer.hospital_heroes.cream_minigame.EndGameSticker;

import java.util.ArrayList;

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
    private boolean soundPlayedAlready;
    private boolean gameFinished, legalToMove, drawn;
    private StarBackground starBackground;
    private RocketSprite rocket;
    private HouseSprite house;
    private EndGameSticker sticker;
    private AsteroidManager asteroidManager;
    private int xCoord, yCoord;
    private boolean reset = true;
    private Canvas canvas;

    /**
     * Constructor for class 'GameView'
     * @param context where the object is being created
     * @param xOfScreen the centre x-coordinate of the screen
     * @param yOfScreen the centre y-coordinate of the screen
     */
    public GameView(Context context, int xOfScreen, int yOfScreen) {
        super(context);

        this.xOfScreen = xOfScreen;
        this.yOfScreen = yOfScreen;
        getHolder().addCallback(this);

        initializeResources();

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

    /**
     * Checks for collisions with hitboxs for reset and ending game
     */
    public void update() {
        if(drawn) {
            if (Rect.intersects(rocket.getHitbox(), asteroidManager.asteroids.get(0).getHitbox())) {
                playCrashSound();
                reset = true;
            } else if (Rect.intersects(rocket.getHitbox(), asteroidManager.asteroids.get(1).getHitbox())) {
                playCrashSound();
                reset = true;
            } else if (Rect.intersects(rocket.getHitbox(), asteroidManager.asteroids.get(2).getHitbox())) {
                playCrashSound();
                reset = true;
            } else if (Rect.intersects(rocket.getHitbox(), asteroidManager.asteroids.get(3).getHitbox())) {
                playCrashSound();
                reset = true;
            } else if (Rect.intersects(rocket.getHitbox(), house.getHitBox())) {
                gameFinished = true;
            }
        }
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.canvas = canvas;
        if(canvas != null && reset) {
            starBackground.draw(canvas);
            house.draw(xOfScreen - xOfScreen/4 + 30, yOfScreen/2 + house.getHeight()/2 - 20, canvas);
            rocket.draw(xOfScreen/16, 2*yOfScreen/5 - rocket.getHeight(), canvas);
            asteroidManager.draw(canvas);
            reset = false;
            legalToMove = false;
        }
        else if(canvas != null){
            starBackground.draw(canvas);
            house.draw(xOfScreen - xOfScreen/4 + 30, yOfScreen/2 + house.getHeight()/2 - 20, canvas);

            if(xCoord == 0 && yCoord == 0) {
                rocket.draw(xOfScreen/16, 2*yOfScreen/5 - rocket.getHeight(), canvas);
            } else if(legalToMove) {
                rocket.draw(xCoord - rocket.getWidth()/2, yCoord - rocket.getHeight()/2, canvas);
            } else {
                rocket.draw(xOfScreen/16, 2*yOfScreen/5 - rocket.getHeight(), canvas);
            }

            asteroidManager.draw(canvas);

            if(gameFinished) { // stuff for game ending
                starBackground.drawDarkenedImage(canvas);
                int value = sticker.drawAnimation(canvas);
                if(!soundPlayedAlready) {
                    playVictorySound();
                }
                if(value == sticker.getWidth()){
                    // wait a bit
//                    try {
//                        Thread.sleep(3000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    // go to next scene
                    gameActivity.nextScene();
                    thread.setRunning(false);
                }
            }
        }
        drawn = true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // User input stuff goes here
        int X = (int) event.getX();
        int Y = (int) event.getY();
        int eventAction = event.getAction();

        switch(eventAction){
            case MotionEvent.ACTION_DOWN:
                xCoord = X;
                yCoord = Y;
                if(rocket.getHitbox().contains(xCoord, yCoord)) {
                    legalToMove = true;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                xCoord = X;
                yCoord = Y;
                break;
            case MotionEvent.ACTION_UP:
                xCoord = 0;
                yCoord = 0;
                legalToMove = false;
                break;
        }
        return true;
    }

    /**
     * Setter for gameActivity field
     * @param activity the activity the object is associated to
     */
    public void setGameActivity(GameActivity activity) {
        gameActivity = activity;
    }

    /**
     * Plays the sound played at collision with asteroids
     */
    public void playCrashSound() {
        SoundEffects.playSound(2);
    }

    /**
     * Plays the victory sound for when the game is completed
     * When the rocket touches the house, the game ends
     */
    public void playVictorySound() {
        soundPlayedAlready = true;
        SoundEffects.playSound(0);
    }

    /**
     * Initialises all sprites needed for the game
     */
    public void initializeResources() {
        starBackground = new StarBackground(xOfScreen, yOfScreen, getResources());
        rocket = new RocketSprite(getResources());
        house = new HouseSprite(getResources());
        asteroidManager = new AsteroidManager(getResources());
        sticker = new EndGameSticker(xOfScreen, yOfScreen, getResources());
    }

    /**
     * Returns the resolution of the screen as an arraylist
     */
    public ArrayList getResolution() {
        ArrayList<Integer> reso = new ArrayList<Integer>();
        reso.add(xOfScreen);
        reso.add(yOfScreen);
        return reso;
    }

    /**
     * Returns all the bitmaps in the game as an arraylist
     */
    public ArrayList getBitmaps() {
        ArrayList<Bitmap> bitmaps = new ArrayList<>();
        bitmaps.add(starBackground.getBitmap());
        bitmaps.add(rocket.getBitmap());
        bitmaps.add(house.getBitmap());
        bitmaps.add(sticker.getBitmap());
        for(Asteroid asteroid : asteroidManager.asteroids) {
            bitmaps.add(asteroid.getBitmap());
        }
        return bitmaps;
    }

    /**
     * Changes the boolean gameFinished to the input parameter
     * @param value the value the boolean is to be set to
     */
    public void setGameFinished(boolean value) {
        gameFinished = value;
    }

    /**
     * This method returns the value of the boolean 'victorySoundPlayedAlready'
     * @return victorySoundPlayedAlready the boolean that determines whether
     * the sound has been played already or not
     */
    public boolean isVictorySoundPlayedAlready() {
        return soundPlayedAlready;
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
}