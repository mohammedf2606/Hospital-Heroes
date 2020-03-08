package com.hummer.educationalgame.CreamMinigame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

import com.hummer.educationalgame.Constants;
import com.hummer.educationalgame.SoundEffects;

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
    private boolean gameFinished, soundPlayedAlready, isWhiteCharacter;
    private GameActivity gameActivity;
    private Canvas canvas;
    private int xCoord, yCoord;
//    private Path path;
    private Paint creamPaint, alphaPaint, betaPaint;
    private EndGameSticker sticker;
    private boolean isTouchingScreen;
    private int progress1, progress2;
    private boolean fullyAppliedCreamOnPos1, fullyAppliedCreamOnPos2;

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

    public void update() {
        if(Rect.intersects(location1.getHitbox(), creamTube.getHitbox()) && isTouchingScreen == true) {
            progress1+=2;
            alphaPaint.setAlpha(progress1);
            if(progress1 > 255) {
                alphaPaint.setAlpha(255);
                fullyAppliedCreamOnPos1 = true;
            }
        } else if(Rect.intersects(location2.getHitbox(), creamTube.getHitbox()) && isTouchingScreen == true) {
            progress2+=2;
            betaPaint.setAlpha(progress2);
            if(progress2 > 255) {
                betaPaint.setAlpha(255);
                fullyAppliedCreamOnPos2 = true;
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
//            canvas.drawPath(path, paint);

            if(gameFinished) {
                background.drawDarkenedImage(canvas);
//                characterArmSprite.drawDarkenedImage(canvas);
//                creamSplatter.drawDarkenedImage(canvas, location1.getXCoord(), location1.getYCoord());
//                creamSplatter.drawDarkenedImage(canvas, location2.getXCoord(), location2.getYCoord());

                //stuff that happens when game is complete
                int value = sticker.drawAnimation(canvas);

                if(soundPlayedAlready == false) {
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

    public void setGameActivity(GameActivity activity) {
        gameActivity = activity;
    }

    public void playVictorySound() {
        soundPlayedAlready = true;
        SoundEffects.playSound(0);
    }

    public void initializeObjects() {
        background = new HospitalBackground(xOfScreen, yOfScreen, getResources());
        characterArmSprite = new CharacterArmSprite(xOfScreen, yOfScreen, getResources(), isWhiteCharacter);
        location1 = new CreamOutline(xOfScreen/8 - 20, yOfScreen/3 - 20, getResources());
        location2 = new CreamOutline(xOfScreen/2 + 100, yOfScreen/3 + 100, getResources());
        creamTube = new CreamTubeSprite(getResources());
        sticker = new EndGameSticker(xOfScreen, yOfScreen, getResources());
        creamSplatter = new CreamSplatter(getResources());
//        path = new Path();
    }

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

    public void drawInitialImages() {
        background.draw(canvas);
        characterArmSprite.draw(canvas);
    }
}
