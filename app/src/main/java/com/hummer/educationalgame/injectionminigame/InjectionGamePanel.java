package com.hummer.educationalgame.injectionminigame;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.provider.SyncStateContract;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.hummer.educationalgame.Constants;
import com.hummer.educationalgame.CreamMinigame.CharacterArmSprite;
import com.hummer.educationalgame.CreamMinigame.EndGameSticker;
import com.hummer.educationalgame.CreamMinigame.HospitalBackground;
import com.hummer.educationalgame.MainMenu;
import com.hummer.educationalgame.PreScan;
import com.hummer.educationalgame.R;

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

    private InjectionMainActivity gameActivity;
    private Canvas canvas;
    private int xCoord, yCoord;

    private EndGameSticker sticker;

    private Point injectionPoint;


    public InjectionGamePanel(Context context, int xOfScreen, int yOfScreen) {
        super(context);
        this.mContext = context;
        InjectionConstants.CURRENT_CONTEXT = this.mContext;

        isWhiteCharacter = !Constants.isBlack();

        this.xOfScreen = xOfScreen;
        this.yOfScreen = yOfScreen;
        getHolder().addCallback(this);

        thread = new InjectionMainThread(getHolder(), this);

        //injection = new Injection(new Rect(100, 100, 200, 200), Color.rgb(255, 0, 0));
        //injectionBody = new InjectionBody(new Rect(200, 200, 400, 400), Color.BLACK);
        //sticker = new InjectionGameOver(4 * InjectionConstants.SCREEN_WIDTH / 4, 4 * InjectionConstants.SCREEN_HEIGHT / 4, context.getResources());

        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        background = new HospitalBackground(xOfScreen, yOfScreen, getResources());
        injectionArm = new CharacterArmSprite(xOfScreen, yOfScreen, getResources(), isWhiteCharacter);
        injection = new Injection(getResources());
        injectionBody = new InjectionBody(xOfScreen/8 - 20, yOfScreen/3 - 20, getResources());
        sticker = new EndGameSticker(xOfScreen, yOfScreen, getResources());

        //injectionPoint = new Point(3 * InjectionConstants.SCREEN_WIDTH / 4, InjectionConstants.SCREEN_HEIGHT / 4);

        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.canvas = canvas;
        if (canvas != null) {

            background.draw(canvas);
            injectionArm.draw(canvas);
            injectionBody.draw(canvas);

            //if(!(xCoord == 0 || yCoord == 0 || gameOver)) {
                int x2 = xCoord;
                int y2 = yCoord - injection.getHeight();
                injection.draw(canvas, x2, y2);
            //}

            if (gameOver) {
                background.drawDarkenedImage(canvas);
                int value = sticker.drawAnimation(canvas);
                if (value == sticker.getWidth())
                {
                    try {
                        thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Intent nextScene = new Intent(mContext, PreScan.class);
                    mContext.startActivity(nextScene);
                }
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int X = (int) event.getX();
        int Y = (int) event.getY();
        int eventAction = event.getAction();

        switch (eventAction) {
            case MotionEvent.ACTION_DOWN:
                //if (!gameOver && injection.getHitbox().contains((int) event.getX(), (int) event.getY())) {
                    movingInjection = true;
                    xCoord = X;
                    yCoord = Y;
                //}
                break;
            case MotionEvent.ACTION_MOVE:
                //if (!gameOver && movingInjection) {
                  //  injectionPoint.set((int) event.getX(), (int) event.getY());
                    xCoord = X;
                    yCoord = Y;
                //}
                break;
            case MotionEvent.ACTION_UP:
                xCoord = 0;
                yCoord = 0;
                movingInjection = false;
                break;
        }
        return true;
    }

    public void update() {
        //if(Rect.intersects(injectionBody.getHitbox(), injection.getHitbox()) && movingInjection == true)
        //if(injectionBody.injectionCollide(injection))
        //    gameOver = true;
        //injection.update(injectionPoint);
        //injectionBody.update();
        if (!gameOver) {
            //injection.update(injectionPoint);
          //  injectionBody.update();
        }
        if (Rect.intersects(injectionBody.getHitbox(), injection.getHitbox()) && movingInjection == true) {
            gameOver = true;
        }
    }

    public void setGameActivity(InjectionMainActivity activity) {
        gameActivity = activity;
    }
}
