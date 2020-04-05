package com.hummer.hospital_heroes.rocket_minigame;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.hummer.hospital_heroes.AppActivity;
import com.hummer.hospital_heroes.Constants;
import com.hummer.hospital_heroes.EndScreen;
import com.hummer.hospital_heroes.R;

/**
 * GameActivity represents the class which contains the activity
 * the game runs in. An activity is a 'screen' which is interactive.
 * The XML for the activity is empty since the background images and
 * sprites are drawn using the GameView class.
 *
 * @author Jawad Zeidan, Fahim Mohammed
 * @version 1.0
 */
public class GameActivity extends AppActivity {

    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.slideinright, R.anim.slideoutright);

        gameView = new GameView(this, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

        setContentView(gameView);
        gameView.setGameActivity(this);
    }

    /**
     * Function used to move to next Activity
     */
    public void nextScene() {
        Intent end_screen = new Intent(GameActivity.this, EndScreen.class);
        startActivity(end_screen);
    }
}