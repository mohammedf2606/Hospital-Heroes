package com.hummer.hospital_heroes.injection_minigame;

import android.graphics.Canvas;

/**
 * InjectionGameObject is one of the main interfaces of the game.
 *
 * @author Fareed Faisal
 * @version 1.0
 */
public interface InjectionGameObject
{
    public void draw(Canvas canvas, int xCoord, int yCoord);

    public void update();


}
