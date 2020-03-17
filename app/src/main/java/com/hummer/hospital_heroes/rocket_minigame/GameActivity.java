package com.hummer.hospital_heroes.rocket_minigame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import com.hummer.hospital_heroes.WaitingRoom;

/**
 * GameActivity represents the class which contains the activity
 * the game runs in. An activity is a 'screen' which is interactive.
 * The XML for the activity is empty since the background images and
 * sprites are drawn using the GameView class.
 *
 * @author Jawad Zeidan, Fahim Mohammed
 * @version 1.0
 */
public class GameActivity extends Activity {

    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        gameView = new GameView(this, displayMetrics.widthPixels, displayMetrics.heightPixels);

        setContentView(gameView);
        gameView.setGameActivity(this);
    }

    /**
     * Function used to move to next Activity
     */
    public void nextScene() {
        Intent waiting_room = new Intent(GameActivity.this, WaitingRoom.class);
        startActivity(waiting_room);
    }
}