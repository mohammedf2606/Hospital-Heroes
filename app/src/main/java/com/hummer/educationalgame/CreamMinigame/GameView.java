package com.hummer.educationalgame.CreamMinigame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
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
 * @author Jawad Zeidan
 * @version 1.0
 */

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private MainThread thread;
    private CharacterArmSprite characterArmSprite;
    private HospitalBackground background;
    private CreamTubeSprite creamTube;
    private CreamApplicationLocation location1, location2;
    private BigCreamSplatter bigSplat;
    private MediumCreamSplatter mediumSplat;
    private SmallCreamSplatter smallSplat;
    private int xOfScreen, yOfScreen;
    private boolean gameFinished, soundPlayedAlready;
    private GameActivity gameActivity;
    private Canvas canvas;
    private int xCoord, yCoord;
    private Path path;
    private Paint paint;
    private EndGameSticker sticker;
    private boolean isTouchingScreen;
    private int progress1, progress2;
    private boolean slightlyAppliedCreamOnPos1, considerablyAppliedCreamOnPos1, fullyAppliedCreamOnPos1;
    private boolean slightlyAppliedCreamOnPos2, considerablyAppliedCreamOnPos2, fullyAppliedCreamOnPos2;

    public GameView(Context context, int xOfScreen, int yOfScreen) {
        super(context);

        this.xOfScreen = xOfScreen;
        this.yOfScreen = yOfScreen;
        getHolder().addCallback(this);

        thread = new MainThread(getHolder(), this);
        setFocusable(true);

        background = new HospitalBackground(xOfScreen, yOfScreen, getResources());
        characterArmSprite = new CharacterArmSprite(xOfScreen, yOfScreen, getResources());
        location1 = new CreamApplicationLocation(xOfScreen/8 - 20, yOfScreen/3 + 50, getResources());
        location2 = new CreamApplicationLocation(xOfScreen/2 + 100, yOfScreen/3 + 60, getResources());
        creamTube = new CreamTubeSprite(getResources());
        bigSplat = new BigCreamSplatter(getResources());
        mediumSplat = new MediumCreamSplatter(getResources());
        smallSplat = new SmallCreamSplatter(getResources());
        sticker = new EndGameSticker(xOfScreen, yOfScreen, getResources());
        paint = new Paint();
        path = new Path();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(10);
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
            progress1++;
            switch(progress1) {
                case 75: slightlyAppliedCreamOnPos1 = true;
                break;
                case 150: considerablyAppliedCreamOnPos1 = true;
                break;
                case 225: fullyAppliedCreamOnPos1 = true;
                break;
            }
        } else if(Rect.intersects(location2.getHitbox(), creamTube.getHitbox()) && isTouchingScreen == true) {
            progress2++;
            switch(progress2) {
                case 75: slightlyAppliedCreamOnPos2 = true;
                break;
                case 150: considerablyAppliedCreamOnPos2 = true;
                break;
                case 225: fullyAppliedCreamOnPos2 = true;
                break;
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

            background.draw(canvas);
            characterArmSprite.draw(canvas);
            location1.draw(canvas);
            location2.draw(canvas);

            if(fullyAppliedCreamOnPos1) {
                bigSplat.draw(canvas, location1.getXCoord(), location1.getYCoord());
            } else if(considerablyAppliedCreamOnPos1) {
                mediumSplat.draw(canvas, location1.getXCoord(), location1.getYCoord());
            } else if(slightlyAppliedCreamOnPos1) {
                smallSplat.draw(canvas, location1.getXCoord(), location1.getYCoord());
            }

            if(fullyAppliedCreamOnPos2) {
                bigSplat.draw(canvas, location2.getXCoord(), location2.getYCoord());
            } else if(considerablyAppliedCreamOnPos2) {
                mediumSplat.draw(canvas, location2.getXCoord(), location2.getYCoord());
            } else if(slightlyAppliedCreamOnPos2) {
                smallSplat.draw(canvas, location2.getXCoord(), location2.getYCoord());
            }

            if(!(xCoord == 0 || yCoord == 0 || gameFinished)) {
                int x2 = xCoord;
                int y2 = yCoord - creamTube.getHeight();
                creamTube.draw(canvas, x2, y2);
                canvas.drawCircle(x2, yCoord, 5, paint);
            }
            canvas.drawPath(path, paint);

            if(gameFinished) {
                background.drawDarkenedImage(canvas);
                characterArmSprite.drawDarkenedImage(canvas);
                bigSplat.drawDarkenedImage(canvas, location1.getXCoord(), location1.getYCoord());
                bigSplat.drawDarkenedImage(canvas, location2.getXCoord(), location2.getYCoord());

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
                if (X >= characterArmSprite.getX() && X < (characterArmSprite.getX() + characterArmSprite.getWidth())
                        && Y >= characterArmSprite.getY() && Y < (characterArmSprite.getY() + characterArmSprite.getHeight())) {
                    // stuff for making cream appear here
                    isTouchingScreen = true;
                    xCoord = X;
                    yCoord = Y;
                    path.moveTo(X, Y);
                    SoundEffects.playSound(1);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (X >= characterArmSprite.getX() && X < (characterArmSprite.getX() + characterArmSprite.getWidth())
                        && Y >= characterArmSprite.getY() && Y < (characterArmSprite.getY() + characterArmSprite.getHeight())) {
                    xCoord = X;
                    yCoord = Y;
                    path.moveTo(X, Y);
                }
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
