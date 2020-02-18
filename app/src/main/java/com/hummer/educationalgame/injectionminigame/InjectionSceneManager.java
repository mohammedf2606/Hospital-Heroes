package com.hummer.educationalgame.injectionminigame;

import android.graphics.Canvas;
import android.view.MotionEvent;

import java.util.ArrayList;

public class InjectionSceneManager
{
    private ArrayList<InjectionScene> scenes = new ArrayList<>();
    public static int ACTIVE_SCENE;

    public InjectionSceneManager()
    {
        ACTIVE_SCENE = 0;
        scenes.add(new InjectionGameplayScene());
    }

    public void receiveTouch(MotionEvent event)
    {
        scenes.get(ACTIVE_SCENE).receiveTouch(event);
    }

    public void update()
    {
        scenes.get(ACTIVE_SCENE).update();
    }

    public void draw(Canvas canvas)
    {
        scenes.get(ACTIVE_SCENE).draw(canvas);
    }
}
