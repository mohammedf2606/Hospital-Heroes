package com.hummer.educationalgame.foodminigame;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class PlateMainThread extends Thread {
    private SurfaceHolder surfaceHolder;
    private PlateView plateView;
    private boolean running;
    public static Canvas canvas;

    public PlateMainThread(SurfaceHolder surfaceHolder, PlateView plateView){
        super();
        this.surfaceHolder = surfaceHolder;
        this.plateView = plateView;
    }

    @Override
    public void run(){
        while(running){
            canvas = null;

            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder){
                    this.plateView.update();
                    this.plateView.draw(canvas);
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

