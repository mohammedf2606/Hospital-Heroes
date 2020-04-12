package com.hummer.hospital_heroes.injection_minigame;

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

    /**
     * The constructor for the main thread class
     * @param surfaceHolder The SurfaceHolder the thread is associated with
     * @param gamePanel The panel object the thread works for
     */
    public InjectionMainThread(SurfaceHolder surfaceHolder, InjectionGamePanel gamePanel){
        super();
        this.surfaceHolder = surfaceHolder;
        this.gamePanel = gamePanel;
    }

    /**
     * runs the thread of the game
     */
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

    /**
     * Sets the boolean 'running' to the parameter.
     *
     * @param  isRunning  the boolean, true if the thread is running.
     */
    public void setRunning(boolean isRunning){
        running = isRunning;
    }
}

