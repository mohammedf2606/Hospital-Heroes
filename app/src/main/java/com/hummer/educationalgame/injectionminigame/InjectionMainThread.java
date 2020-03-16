package com.hummer.educationalgame.injectionminigame;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * InjectionMainThread is the class of the game that represents the main thread. It builds
 * and displays the main thread and intialises all other components.
 *
 * @author Fareed Faisal
 * @version 1.0
 */
public class InjectionMainThread extends Thread {
    private SurfaceHolder surfaceHolder;
    private InjectionGamePanel gamePanel;
    private boolean running;
    public static Canvas canvas;

    public InjectionMainThread(SurfaceHolder surfaceHolder, InjectionGamePanel gamePanel){
        super();
        this.surfaceHolder = surfaceHolder;
        this.gamePanel = gamePanel;
    }

    @Override
    public void run(){
        while(running){
            canvas = null;

            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder){
                    this.gamePanel.update();
                    this.gamePanel.draw(canvas);
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

