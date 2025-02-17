package com.hummer.hospital_heroes.injection_minigame;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.hummer.hospital_heroes.Constants;
import com.hummer.hospital_heroes.cream_minigame.CharacterArmSprite;
import com.hummer.hospital_heroes.cream_minigame.EndGameSticker;
import com.hummer.hospital_heroes.cream_minigame.HospitalBackground;
import com.hummer.hospital_heroes.PreScan;
import com.hummer.hospital_heroes.SoundEffects;
import com.hummer.hospital_heroes.rocket_minigame.Asteroid;

import java.util.ArrayList;

/**
 * InjectionGamePanel is the class of the game that represents the game panel. It builds
 * and displays the game panel and initialises all other components.
 *
 * @author Fareed Faisal
 * @version 1.0
 */
public class InjectionGamePanel extends SurfaceView implements SurfaceHolder.Callback {
    private Context mContext;

    private InjectionMainThread thread;
    private HospitalBackground background;
    private CharacterArmSprite injectionArm;
    private Injection injection;
    private InjectionBody injectionBody;

    private int xOfScreen, yOfScreen;
    private boolean gameOver = false;
    private boolean isWhiteCharacter;
    private boolean movingInjection = false;
    private boolean victorySoundPlayedAlready;
    private InjectionMainActivity gameActivity;
    private Canvas canvas;
    private int xCoord, yCoord;

    private EndGameSticker sticker;

    private Point injectionPoint;

    /**
     *  set up the game initial screen
     * @param context the app context for mini game
     * @param xOfScreen the horizontal size of screen
     * @param yOfScreen the vertical size of screen
     */
    public InjectionGamePanel(Context context, int xOfScreen, int yOfScreen) {
        super(context);
        this.mContext = context;
        InjectionConstants.CURRENT_CONTEXT = this.mContext;

        isWhiteCharacter = !Constants.isBlack();

        this.xOfScreen = xOfScreen;
        this.yOfScreen = yOfScreen;
        getHolder().addCallback(this);

        thread = new InjectionMainThread(getHolder(), this);

        setFocusable(true);
    }

    /**
     * Changes the boolean gameFinished to the input parameter
     * @param value the value the boolean is to be set to
     */
    public void setGameOver(boolean value) {
        gameOver = value;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    /**
     *  start the thread and display all objects to begin the game
     * @param holder the surfaceholder the game is run on
     */
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        background = new HospitalBackground(xOfScreen, yOfScreen, getResources());
        injectionArm = new CharacterArmSprite(xOfScreen, yOfScreen, getResources(), isWhiteCharacter);
        injection = new Injection(getResources());
        injectionBody = new InjectionBody(xOfScreen/2 + 100, yOfScreen/3 + 100, getResources());
        sticker = new EndGameSticker(xOfScreen, yOfScreen, getResources());

        thread.setRunning(true);
        thread.start();
    }

    /**
     * Returns all the bitmaps in the game as an arraylist
     */
    public ArrayList getBitmaps() {
        ArrayList<Bitmap> bitmaps = new ArrayList<>();
        bitmaps.add(background.getBitmap());
        bitmaps.add(injection.getBitmap());
        bitmaps.add(injectionArm.getBitmap());
        bitmaps.add(sticker.getBitmap());
        return bitmaps;
    }

    /**
     *  end the thread of the game when it is complete
     * @param holder the surfaceholder the game is run on
     */
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

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.canvas = canvas;
        if (canvas != null) {

            background.draw(canvas);
            injectionArm.draw(canvas);
            injectionBody.draw(canvas);

            if(xCoord == 0 && yCoord == 0) {
                injection.draw(canvas, xOfScreen/16, 2*yOfScreen/5 - injection.getHeight());
            } else if(movingInjection) {
                injection.draw(canvas,xCoord - injection.getWidth()/2, yCoord - injection.getHeight()/2);
            } else {
                injection.draw(canvas,xOfScreen/16, 2*yOfScreen/5 - injection.getHeight());
            }

            if (gameOver) {
                background.drawDarkenedImage(canvas);
                if(!victorySoundPlayedAlready) {
                    playVictorySound();
                }
                int value = sticker.drawAnimation(canvas);
                if (value == sticker.getWidth()) {
                    Intent nextScene = new Intent(mContext, PreScan.class);
                    mContext.startActivity(nextScene);
                    thread.setRunning(false);
                }
            }
        }
    }

    /**
     *  register the input event and perfom the corresponding action in the game
     * @param event the motion input by user
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int X = (int) event.getX();
        int Y = (int) event.getY();
        int eventAction = event.getAction();

        switch (eventAction) {
            case MotionEvent.ACTION_DOWN:
                movingInjection = true;
                xCoord = X;
                yCoord = Y;
                break;
            case MotionEvent.ACTION_MOVE:
                xCoord = X;
                yCoord = Y;
                break;
            case MotionEvent.ACTION_UP:
                xCoord = 0;
                yCoord = 0;
                movingInjection = false;
                break;
        }
        return true;
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
     * This method returns the endgame sticker that appears
     * @return sticker the endgame sticker
     */
    public EndGameSticker getSticker() {
        return sticker;
    }

    /**
     * This method returns the canvas of the game
     * @return canvas the canvas the game is being painted onto
     */
    public Canvas getCanvas() {
        return canvas;
    }

    /**
     *  update the game activity for when the collision occurs
     *
     */
    public void update() {
        if (Rect.intersects(injectionBody.getHitbox(), injection.getHitbox()) && movingInjection) {
            gameOver = true;
        }
    }

    /**
     * set the main activity of the game
     * @param activity the bundle of the activity
     */
    public void setGameActivity(InjectionMainActivity activity) {
        gameActivity = activity;
    }

    /**
     *  play the success sound for when the game ends
     */
    public void playVictorySound() {
        victorySoundPlayedAlready = true;
        SoundEffects.playSound(0);
    }

    /**
     * This method returns the value of the boolean 'victorySoundPlayedAlready'
     * @return victorySoundPlayedAlready the boolean that determines whether
     * the sound has been played already or not
     */
    public boolean isVictorySoundPlayedAlready() {
        return victorySoundPlayedAlready;
    }
}
