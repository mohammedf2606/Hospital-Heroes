package com.hummer.educationalgame.rocketminigame;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.ArrayList;

public class AsteroidManager {

    ArrayList<Asteroid> asteroids;
    private Resources res;

    public AsteroidManager(Resources res) {
        this.res = res;

        asteroids = new ArrayList<>();

        populateAsteroids();
    }

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

    public void draw(Canvas canvas) {
        for(Asteroid ast : asteroids) {
            ast.draw(canvas);
        }
    }
}
