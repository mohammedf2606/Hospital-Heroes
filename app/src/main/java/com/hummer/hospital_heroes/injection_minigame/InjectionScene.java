package com.hummer.hospital_heroes.injection_minigame;

import android.graphics.Canvas;
import android.view.MotionEvent;

/**
 * InjectionScene is one of 2 main interfaces of the game. 
 *
 * @author Fareed Faisal
 * @version 1.0
 */
public interface InjectionScene
{
    public void update();
    public void draw(Canvas canvas);
    public void terminate();
    public void receiveTouch(MotionEvent event);
}
