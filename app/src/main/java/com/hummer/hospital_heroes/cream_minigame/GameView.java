package com.hummer.hospital_heroes.cream_minigame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

import com.hummer.hospital_heroes.Constants;
import com.hummer.hospital_heroes.SoundEffects;

import java.util.ArrayList;

/**
 * GameView represents the powerhouse class of the package. All
 * the processes and logic are processed here, including drawing bitmaps,
 * checking conditions and evaluating expressions.
 *
 * @author Jawad Zeidan
 * @version 1.0
 */

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private MainThread thread;
    private CharacterArmSprite characterArmSprite;
    private HospitalBackground background;
    private CreamTubeSprite creamTube;
    private CreamOutline location1, location2;
    private CreamSplatter creamSplatter;
    private int xOfScreen, yOfScreen;
    private boolean gameFinished, dingSoundPlayedAlready, victorySoundPlayedAlready, isWhiteCharacter;
    private GameActivity gameActivity;
    private Canvas canvas;
    private int xCoord, yCoord;
    private Paint creamPaint, alphaPaint, betaPaint;
    private EndGameSticker sticker;
    private boolean isTouchingScreen;
    private int progress1, progress2;
    private boolean fullyAppliedCreamOnPos1, fullyAppliedCreamOnPos2;

    /**
     *  The constructor for the class 'GameView'
     * @param context The Context the view is associated with
     * @param xOfScreen The width of the screen
     * @param yOfScreen The height of the screen
     */
    public GameView(Context context, int xOfScreen, int yOfScreen) {
        super(context);

        isWhiteCharacter = !Constants.isBlack();

        this.xOfScreen = xOfScreen;
        this.yOfScreen = yOfScreen;
        getHolder().addCallback(this);

        thread = new MainThread(getHolder(), this);
        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        initializeObjects();
        initializePaint();
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
     * This method runs every frame and computes the logic for the game,
     * including whether hitboxes collide, and hence evaluating boolean expressions
     */
    public void update() {
        if(Rect.intersects(location1.getHitbox(), creamTube.getHitbox()) && isTouchingScreen == true) {
            progress1+=2;
            alphaPaint.setAlpha(progress1);
            if(progress1 > 255) {
                alphaPaint.setAlpha(255);
                fullyAppliedCreamOnPos1 = true;
                if(dingSoundPlayedAlready == false) {
                    playDingSound();
                }
            }
        } else if(Rect.intersects(location2.getHitbox(), creamTube.getHitbox()) && isTouchingScreen == true) {
            progress2+=2;
            betaPaint.setAlpha(progress2);
            if(progress2 > 255) {
                betaPaint.setAlpha(255);
                fullyAppliedCreamOnPos2 = true;
                if(dingSoundPlayedAlready == false) {
                    playDingSound();
                }
            }
        }
        if(fullyAppliedCreamOnPos1 && fullyAppliedCreamOnPos2) {
            // Minigame ends/ sticker appears.
            gameFinished = true;
        }
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.canvas = canvas;
        if(canvas != null) {

            drawInitialImages();

            if(progress1 > 0 && progress1 < 255) {
                location1.draw(canvas);
                creamSplatter.draw(canvas, location1.getXCoord(), location1.getYCoord(), alphaPaint);
            } else if(progress1 > 0) {
                creamSplatter.draw(canvas, location1.getXCoord(), location1.getYCoord(), alphaPaint);
            } else {
                location1.draw(canvas);
            }

            if(progress2 > 0 && progress2 < 255) {
                location2.draw(canvas);
                creamSplatter.draw(canvas, location2.getXCoord(), location2.getYCoord(), betaPaint);
            } else if(progress2 > 0) {
                creamSplatter.draw(canvas, location2.getXCoord(), location2.getYCoord(), betaPaint);
            } else {
                location2.draw(canvas);
            }

            if(!(xCoord == 0 || yCoord == 0 || gameFinished)) {
                int x2 = xCoord;
                int y2 = yCoord - creamTube.getHeight();
                creamTube.draw(canvas, x2, y2);
                canvas.drawCircle(x2, yCoord, 5, creamPaint);
            }

            if(gameFinished) {
                background.drawDarkenedImage(canvas);

                //stuff that happens when game is complete
                int value = sticker.drawAnimation(canvas);

                if(victorySoundPlayedAlready == false) {
                    playVictorySound();
                }

                if(value == sticker.getWidth()) {
                    // go to next scene
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
                    // stuff for making cream appear here
                    isTouchingScreen = true;
                    xCoord = X;
                    yCoord = Y;
                    SoundEffects.playSound(1);
                break;
            case MotionEvent.ACTION_MOVE:
                    xCoord = X;
                    yCoord = Y;
                break;
            case MotionEvent.ACTION_UP:
                xCoord = 0;
                yCoord = 0;
                isTouchingScreen = false;
                break;
        }
        return true;
    }

    /**
     * Set the current GameActivity to the one parameterised.
     *
     * @param  activity  the GameActivity to be set
     */
    public void setGameActivity(GameActivity activity) {
        gameActivity = activity;
    }

    /**
     * Plays the 'victory chime' sound whenever called. Only plays it once.
     */
    public void playVictorySound() {
        victorySoundPlayedAlready = true;
        SoundEffects.playSound(0);
    }

    /**
     * Plays the 'ding' sound whenever called. Only plays it once.
     */
    public void playDingSound() {
        dingSoundPlayedAlready = true;
        SoundEffects.playSound(3);
    }

    /**
     * Creates and initialises all objects, usually the stuff that should be
     * in the constructor
     */
    public void initializeObjects() {
        background = new HospitalBackground(xOfScreen, yOfScreen, getResources());
        characterArmSprite = new CharacterArmSprite(xOfScreen, yOfScreen, getResources(), isWhiteCharacter);
        location1 = new CreamOutline(xOfScreen/8 - 20, yOfScreen/3 - 20, getResources());
        location2 = new CreamOutline(xOfScreen/2 + 100, yOfScreen/3 + 100, getResources());
        creamTube = new CreamTubeSprite(getResources());
        sticker = new EndGameSticker(xOfScreen, yOfScreen, getResources());
        creamSplatter = new CreamSplatter(getResources());
    }

    /**
     * Creates and initialises the paint that is used to change
     * the opacity of the cream splatter
     */
    public void initializePaint() {
        creamPaint = new Paint();
        creamPaint.setStyle(Paint.Style.STROKE);
        creamPaint.setColor(Color.YELLOW);
        creamPaint.setStrokeWidth(10);

        alphaPaint = new Paint();
        alphaPaint.setAlpha(0);

        betaPaint = new Paint();
        betaPaint.setAlpha(0);
    }

    /**
     * Draws the background of the game and the characters arm
     */
    public void drawInitialImages() {
        background.draw(canvas);
        characterArmSprite.draw(canvas);
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
        bitmaps.add(background.getBitmap());
        bitmaps.add(characterArmSprite.getBitmap());
        bitmaps.add(creamSplatter.getBitmap());
        bitmaps.add(creamTube.getBitmap());
        bitmaps.add(location1.getBitmap());
        bitmaps.add(location2.getBitmap());
        bitmaps.add(sticker.getBitmap());
        return bitmaps;
    }

    /**
     * Returns whether the screen is being touched or not
     */
    public boolean isTouchingScreen() {
        return isTouchingScreen;
    }

    public void finishGame() {
        fullyAppliedCreamOnPos1 = true;
        fullyAppliedCreamOnPos2 = true;
    }

    public boolean isGameFinished() {
        return gameFinished;
    }
}
