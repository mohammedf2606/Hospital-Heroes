package com.hummer.hospital_heroes.milk_minigame;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * MilkMainThread represents the class that acts as the main
 * thread for the food game. What this does is loop continuously and
 * initialize the canvas (screen to be drawn on) as well as call the
 * GameView's draw and update methods continuously. Essentially it
 * acts as the game's main loop.
 *
 * @author Manav Parikh
 * @version 1.0
 */
public class MilkMainThread extends Thread {
    private SurfaceHolder surfaceHolder;
    private MilkGameView milkGameView;
    private boolean running;
    public static Canvas canvas;

    public MilkMainThread(SurfaceHolder surfaceHolder, MilkGameView milkGameView){
        super();
        this.surfaceHolder = surfaceHolder;
        this.milkGameView = milkGameView;
    }

    @Override
    public void run(){
        while(running){
            canvas = null;

            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder){
                    this.milkGameView.update();
                    this.milkGameView.draw(canvas);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if(canvas != null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void setRunning(boolean isRunning){
        running = isRunning;
    }
}

