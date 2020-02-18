package com.hummer.educationalgame.injectionminigame;

import android.graphics.Canvas;
import android.view.MotionEvent;

public interface InjectionScene
{
    public void update();
    public void draw(Canvas canvas);
    public void terminate();
    public void receiveTouch(MotionEvent event);
}
