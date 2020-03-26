package com.hummer.hospital_heroes.rocket_minigame;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.ArrayList;

/**
 * Class that handles Asteroid objects in the Rocket Minigame
 * @author Fahim Mohammed, Jawad Zeidan
 */
public class AsteroidManager {

    ArrayList<Asteroid> asteroids;
    private Resources res;

    /**
     * Constructor for AsteroidManager
     * @param res Resources object to be used by Asteroid class to generate Bitmap image
     */
    public AsteroidManager(Resources res) {
        this.res = res;

        asteroids = new ArrayList<>();

        populateAsteroids();
    }
    /**
     * Creates asteroid objects and adds them to ArrayList
     */
    private void populateAsteroids() {
        Asteroid asteroid1 = new Asteroid(res, 50, 380);
        Asteroid asteroid2 = new Asteroid(res, 300, 40);
        Asteroid asteroid3 = new Asteroid(res, 500, 380);
        Asteroid asteroid4 = new Asteroid(res, 700, 40);
        asteroids.add(asteroid1);
        asteroids.add(asteroid2);
        asteroids.add(asteroid3);
        asteroids.add(asteroid4);
    }

    /**
     * Draw method that draws all the asteroids
     * @param canvas the canvas to be drawn on
     */
    public void draw(Canvas canvas) {
        for(Asteroid ast : asteroids) {
            ast.draw(canvas);
        }
    }
}
